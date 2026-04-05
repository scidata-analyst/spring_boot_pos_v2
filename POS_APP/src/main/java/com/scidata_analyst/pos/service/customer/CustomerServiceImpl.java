package com.scidata_analyst.pos.service.customer;

import com.scidata_analyst.pos.dto.customer.CustomerDTO;
import com.scidata_analyst.pos.dto.customer.CustomerPurchaseHistoryDTO;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.entity.Customer;
import com.scidata_analyst.pos.entity.Sale;
import com.scidata_analyst.pos.repository.customer.CustomerRepository;
import com.scidata_analyst.pos.repository.sale.SaleRepository;
import com.scidata_analyst.pos.request.customer.CreateCustomerRequest;
import com.scidata_analyst.pos.request.customer.SearchCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateLoyaltyPointsRequest;
import com.scidata_analyst.pos.response.customer.LoyaltyPointsResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Override
    public CustomerDTO createCustomer(CreateCustomerRequest request) {
        if (request.getEmail() != null && customerRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Customer with email " + request.getEmail() + " already exists");
        }

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .zipCode(request.getZipCode())
                .build();

        Customer saved = customerRepository.save(customer);
        return mapToDTO(saved);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));

        if (request.getFirstName() != null) customer.setFirstName(request.getFirstName());
        if (request.getLastName() != null) customer.setLastName(request.getLastName());
        if (request.getEmail() != null) {
            if (!customer.getEmail().equals(request.getEmail()) && customerRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("Customer with email " + request.getEmail() + " already exists");
            }
            customer.setEmail(request.getEmail());
        }
        if (request.getPhone() != null) customer.setPhone(request.getPhone());
        if (request.getAddress() != null) customer.setAddress(request.getAddress());
        if (request.getCity() != null) customer.setCity(request.getCity());
        if (request.getState() != null) customer.setState(request.getState());
        if (request.getZipCode() != null) customer.setZipCode(request.getZipCode());
        if (request.getIsActive() != null) customer.setIsActive(request.getIsActive());

        Customer updated = customerRepository.save(customer);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        return mapToDTO(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> searchCustomers(SearchCustomerRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<Customer> customers = customerRepository.searchCustomers(
                request.getKeyword(),
                request.getEmail(),
                request.getPhone(),
                request.getIsActive(),
                pageable
        );

        return customers.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllActiveCustomers() {
        return customerRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerPurchaseHistoryDTO getPurchaseHistory(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<Sale> sales = customer.getSales() != null ? customer.getSales() : List.of();

        long totalOrders = sales.size();
        BigDecimal totalSpent = sales.stream()
                .map(Sale::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageOrderValue = totalOrders > 0
                ? totalSpent.divide(BigDecimal.valueOf(totalOrders), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        LocalDate firstPurchaseDate = sales.stream()
                .map(Sale::getCreatedAt)
                .map(LocalDateTime::toLocalDate)
                .min(LocalDate::compareTo)
                .orElse(null);

        LocalDate lastPurchaseDate = sales.stream()
                .map(Sale::getCreatedAt)
                .map(LocalDateTime::toLocalDate)
                .max(LocalDate::compareTo)
                .orElse(null);

        String preferredPaymentMethod = sales.stream()
                .collect(Collectors.groupingBy(Sale::getPaymentMethod, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return CustomerPurchaseHistoryDTO.builder()
                .customerId(customer.getId())
                .customerName(customer.getFirstName() + " " + customer.getLastName())
                .totalOrders(totalOrders)
                .totalSpent(totalSpent)
                .averageOrderValue(averageOrderValue)
                .firstPurchaseDate(firstPurchaseDate)
                .lastPurchaseDate(lastPurchaseDate)
                .loyaltyPoints(customer.getLoyaltyPoints())
                .preferredPaymentMethod(preferredPaymentMethod)
                .build();
    }

    @Override
    public LoyaltyPointsResponse updateLoyaltyPoints(UpdateLoyaltyPointsRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + request.getCustomerId()));

        double previousPoints = customer.getLoyaltyPoints() != null ? customer.getLoyaltyPoints() : 0.0;
        double newPoints;

        switch (request.getOperation()) {
            case ADD:
                newPoints = previousPoints + request.getPoints();
                break;
            case SUBTRACT:
                newPoints = previousPoints - request.getPoints();
                if (newPoints < 0) throw new IllegalArgumentException("Insufficient loyalty points");
                break;
            case SET:
                newPoints = request.getPoints();
                break;
            default:
                throw new IllegalArgumentException("Invalid loyalty operation");
        }

        customer.setLoyaltyPoints(newPoints);
        customerRepository.save(customer);

        return LoyaltyPointsResponse.builder()
                .customerId(customer.getId())
                .customerName(customer.getFirstName() + " " + customer.getLastName())
                .previousPoints(previousPoints)
                .pointsChanged(request.getPoints())
                .currentPoints(newPoints)
                .operation(request.getOperation().name())
                .notes(request.getNotes())
                .updatedAt(LocalDateTime.now().toString())
                .build();
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public void deactivateCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        customer.setIsActive(false);
        customerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerByPhone(String phone) {
        Customer customer = customerRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with phone: " + phone));
        return mapToDTO(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getCustomerSales(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<Sale> sales = customer.getSales() != null ? customer.getSales() : List.of();
        return sales.stream()
                .sorted(Comparator.comparing(Sale::getCreatedAt).reversed())
                .map(this::mapToSaleSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getCustomerRecentSales(Long customerId, Integer limit) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<Sale> sales = customer.getSales() != null ? customer.getSales() : List.of();
        return sales.stream()
                .sorted(Comparator.comparing(Sale::getCreatedAt).reversed())
                .limit(limit)
                .map(this::mapToSaleSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getCustomerSalesSummary(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<Sale> sales = customer.getSales() != null ? customer.getSales() : List.of();
        long totalOrders = sales.size();
        BigDecimal totalSpent = sales.stream().map(Sale::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal averageOrderValue = totalOrders > 0
                ? totalSpent.divide(BigDecimal.valueOf(totalOrders), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        Map<String, Object> summary = new HashMap<>();
        summary.put("customerId", customer.getId());
        summary.put("customerName", customer.getFirstName() + " " + customer.getLastName());
        summary.put("totalOrders", totalOrders);
        summary.put("totalSpent", totalSpent);
        summary.put("averageOrderValue", averageOrderValue);
        summary.put("loyaltyPoints", customer.getLoyaltyPoints());
        return summary;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getCustomerSalesByDateRange(Long customerId, LocalDate startDate, LocalDate endDate) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        List<Sale> sales = customer.getSales() != null ? customer.getSales() : List.of();
        return sales.stream()
                .filter(s -> !s.getCreatedAt().isBefore(start) && !s.getCreatedAt().isAfter(end))
                .sorted(Comparator.comparing(Sale::getCreatedAt).reversed())
                .map(this::mapToSaleSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getTopCustomers(Integer limit) {
        List<Customer> allCustomers = customerRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE)).getContent();

        return allCustomers.stream()
                .sorted(Comparator.comparingDouble((Customer c) -> c.getSales() != null
                        ? c.getSales().stream().map(Sale::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()
                        : 0.0).reversed())
                .limit(limit)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CustomerDTO mapToDTO(Customer customer) {
        long totalOrders = customer.getSales() != null ? customer.getSales().size() : 0;
        double totalSpent = customer.getSales() != null
                ? customer.getSales().stream().map(Sale::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()
                : 0.0;

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .fullName(customer.getFirstName() + " " + customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .city(customer.getCity())
                .state(customer.getState())
                .zipCode(customer.getZipCode())
                .loyaltyPoints(customer.getLoyaltyPoints())
                .isActive(customer.getIsActive())
                .totalOrders(totalOrders)
                .totalSpent(totalSpent)
                .build();
    }

    private SaleSummaryDTO mapToSaleSummaryDTO(Sale sale) {
        return SaleSummaryDTO.builder()
                .id(sale.getId())
                .invoiceNumber(sale.getInvoiceNumber())
                .customerName(sale.getCustomer() != null ? sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName() : "Walk-in")
                .cashierName(sale.getUser() != null ? sale.getUser().getUsername() : null)
                .itemCount(sale.getSaleItems() != null ? sale.getSaleItems().size() : 0)
                .subtotal(sale.getSubtotal())
                .tax(sale.getTax())
                .discount(sale.getDiscount())
                .total(sale.getTotal())
                .paymentMethod(sale.getPaymentMethod())
                .status(sale.getStatus())
                .createdAt(sale.getCreatedAt())
                .build();
    }
}
