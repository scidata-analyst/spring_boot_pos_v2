package com.scidata_analyst.pos.service.sale;

import com.scidata_analyst.pos.controller.sale.SaleController.SaleItemRequest;
import com.scidata_analyst.pos.dto.sale.SaleDTO;
import com.scidata_analyst.pos.dto.sale.SaleItemResponse;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.dto.sale.SalesReportDTO;
import com.scidata_analyst.pos.entity.*;
import com.scidata_analyst.pos.repository.customer.CustomerRepository;
import com.scidata_analyst.pos.repository.payment.PaymentRepository;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import com.scidata_analyst.pos.repository.sale.SaleItemRepository;
import com.scidata_analyst.pos.repository.sale.SaleRepository;
import com.scidata_analyst.pos.repository.user.UserRepository;
import com.scidata_analyst.pos.request.sale.CreateSaleRequest;
import com.scidata_analyst.pos.request.sale.ProcessPaymentRequest;
import com.scidata_analyst.pos.request.sale.SearchSaleRequest;
import com.scidata_analyst.pos.request.sale.UpdateSaleRequest;
import com.scidata_analyst.pos.response.sale.PaymentProcessResponse;
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
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final SaleItemRepository saleItemRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public SaleDTO createSale(CreateSaleRequest request) {
        Sale sale = Sale.builder()
                .invoiceNumber(generateInvoiceNumber())
                .subtotal(BigDecimal.ZERO)
                .tax(request.getTax())
                .discount(request.getDiscount() != null ? request.getDiscount() : BigDecimal.ZERO)
                .total(BigDecimal.ZERO)
                .amountPaid(BigDecimal.ZERO)
                .changeAmount(BigDecimal.ZERO)
                .paymentMethod(request.getPaymentMethod())
                .notes(request.getNotes())
                .build();

        if (request.getCustomerId() != null) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + request.getCustomerId()));
            sale.setCustomer(customer);
        }

        List<SaleItem> saleItems = new ArrayList<>();
        BigDecimal subtotal = BigDecimal.ZERO;

        for (CreateSaleRequest.SaleItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + itemRequest.getProductId()));

            if (product.getStockQuantity() < itemRequest.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
            }

            product.setStockQuantity(product.getStockQuantity() - itemRequest.getQuantity());
            productRepository.save(product);

            BigDecimal itemTotal = itemRequest.getUnitPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            if (itemRequest.getDiscount() != null) {
                itemTotal = itemTotal.subtract(itemRequest.getDiscount());
            }

            SaleItem item = SaleItem.builder()
                    .sale(sale)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .unitPrice(itemRequest.getUnitPrice())
                    .discount(itemRequest.getDiscount())
                    .total(itemTotal)
                    .build();

            saleItems.add(item);
            subtotal = subtotal.add(itemTotal);
        }

        sale.setSaleItems(saleItems);
        sale.setSubtotal(subtotal);

        BigDecimal total = subtotal.add(request.getTax()).subtract(sale.getDiscount());
        sale.setTotal(total);

        Sale saved = saleRepository.save(sale);
        return mapToDTO(saved);
    }

    @Override
    public SaleDTO updateSale(Long id, UpdateSaleRequest request) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + id));

        if (request.getStatus() != null) sale.setStatus(request.getStatus());
        if (request.getNotes() != null) sale.setNotes(request.getNotes());

        Sale updated = saleRepository.save(sale);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + id));
        return mapToDTO(sale);
    }

    @Override
    @Transactional(readOnly = true)
    public SaleDTO getSaleByInvoiceNumber(String invoiceNumber) {
        Sale sale = saleRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with invoice number: " + invoiceNumber));
        return mapToDTO(sale);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SaleSummaryDTO> searchSales(SearchSaleRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        LocalDateTime startDate = request.getStartDate() != null ? request.getStartDate().atStartOfDay() : null;
        LocalDateTime endDate = request.getEndDate() != null ? request.getEndDate().atTime(23, 59, 59) : null;

        Page<Sale> sales = saleRepository.searchSales(
                request.getInvoiceNumber(),
                request.getCustomerId(),
                request.getUserId(),
                request.getPaymentMethod(),
                request.getStatus(),
                startDate,
                endDate,
                pageable
        );

        return sales.map(this::mapToSummaryDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getRecentSales(Integer limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "createdAt"));
        return saleRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(this::mapToSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentProcessResponse processPayment(ProcessPaymentRequest request) {
        Sale sale = saleRepository.findById(request.getSaleId())
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + request.getSaleId()));

        BigDecimal newAmountPaid = sale.getAmountPaid().add(request.getAmount());
        sale.setAmountPaid(newAmountPaid);
        sale.setChangeAmount(newAmountPaid.subtract(sale.getTotal()));

        if (newAmountPaid.compareTo(sale.getTotal()) >= 0) {
            sale.setStatus("PAID");
        } else {
            sale.setStatus("PARTIAL");
        }

        saleRepository.save(sale);

        return PaymentProcessResponse.builder()
                .saleId(sale.getId())
                .invoiceNumber(sale.getInvoiceNumber())
                .totalAmount(sale.getTotal())
                .amountPaid(newAmountPaid)
                .changeAmount(sale.getChangeAmount())
                .paymentMethod(request.getPaymentMethod())
                .status(sale.getStatus())
                .processedAt(LocalDateTime.now())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public SalesReportDTO getSalesReport(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        Long totalTransactions = saleRepository.getTotalTransactionsByDateRange(start, end);
        BigDecimal grossSales = saleRepository.getTotalSalesByDateRange(start, end);

        return SalesReportDTO.builder()
                .date(startDate)
                .totalTransactions(totalTransactions)
                .grossSales(grossSales)
                .totalDiscounts(BigDecimal.ZERO)
                .totalTax(BigDecimal.ZERO)
                .netSales(grossSales)
                .averageTransactionValue(totalTransactions > 0
                        ? grossSales.divide(BigDecimal.valueOf(totalTransactions), 2, BigDecimal.ROUND_HALF_UP)
                        : BigDecimal.ZERO)
                .topPaymentMethod("CASH")
                .itemsSold(0L)
                .build();
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new EntityNotFoundException("Sale not found with id: " + id);
        }
        saleRepository.deleteById(id);
    }

    @Override
    public void cancelSale(Long id, String reason) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + id));
        sale.setStatus("CANCELLED");
        sale.setNotes(reason);
        saleRepository.save(sale);
    }

    @Override
    @Transactional(readOnly = true)
    public String generateInvoiceNumber() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = saleRepository.count() + 1;
        return "INV-" + date + "-" + String.format("%06d", count);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getTotalSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return saleRepository.getTotalSalesByDateRange(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getTotalTransactionsByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return saleRepository.getTotalTransactionsByDateRange(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleItemResponse> getSaleItems(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));

        return sale.getSaleItems() != null
                ? sale.getSaleItems().stream().map(this::mapToItemResponse).collect(Collectors.toList())
                : List.of();
    }

    @Override
    public SaleItemResponse addSaleItem(Long saleId, SaleItemRequest request) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + request.getProductId()));

        if (product.getStockQuantity() < request.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
        }

        product.setStockQuantity(product.getStockQuantity() - request.getQuantity());
        productRepository.save(product);

        BigDecimal itemTotal = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
        if (request.getDiscount() != null) {
            itemTotal = itemTotal.subtract(request.getDiscount());
        }

        SaleItem item = SaleItem.builder()
                .sale(sale)
                .product(product)
                .quantity(request.getQuantity())
                .unitPrice(request.getUnitPrice())
                .discount(request.getDiscount())
                .total(itemTotal)
                .build();

        saleItemRepository.save(item);

        sale.setSubtotal(sale.getSubtotal().add(itemTotal));
        sale.setTotal(sale.getSubtotal().add(sale.getTax()).subtract(sale.getDiscount()));
        saleRepository.save(sale);

        return mapToItemResponse(item);
    }

    @Override
    public SaleItemResponse updateSaleItem(Long saleId, Long itemId, SaleItemRequest request) {
        SaleItem item = saleItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Sale item not found with id: " + itemId));

        if (!item.getSale().getId().equals(saleId)) {
            throw new IllegalArgumentException("Sale item does not belong to the specified sale");
        }

        Product product = item.getProduct();
        int quantityDiff = request.getQuantity() - item.getQuantity();

        if (product.getStockQuantity() < quantityDiff) {
            throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
        }

        product.setStockQuantity(product.getStockQuantity() - quantityDiff);
        productRepository.save(product);

        item.setQuantity(request.getQuantity());
        if (request.getUnitPrice() != null) item.setUnitPrice(request.getUnitPrice());
        if (request.getDiscount() != null) item.setDiscount(request.getDiscount());

        BigDecimal itemTotal = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        if (item.getDiscount() != null) {
            itemTotal = itemTotal.subtract(item.getDiscount());
        }
        item.setTotal(itemTotal);

        saleItemRepository.save(item);

        Sale sale = item.getSale();
        BigDecimal newSubtotal = sale.getSaleItems().stream().map(SaleItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setSubtotal(newSubtotal);
        sale.setTotal(newSubtotal.add(sale.getTax()).subtract(sale.getDiscount()));
        saleRepository.save(sale);

        return mapToItemResponse(item);
    }

    @Override
    public void removeSaleItem(Long saleId, Long itemId) {
        SaleItem item = saleItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Sale item not found with id: " + itemId));

        if (!item.getSale().getId().equals(saleId)) {
            throw new IllegalArgumentException("Sale item does not belong to the specified sale");
        }

        Product product = item.getProduct();
        product.setStockQuantity(product.getStockQuantity() + item.getQuantity());
        productRepository.save(product);

        Sale sale = item.getSale();
        BigDecimal newSubtotal = sale.getSubtotal().subtract(item.getTotal());
        sale.setSubtotal(newSubtotal);
        sale.setTotal(newSubtotal.add(sale.getTax()).subtract(sale.getDiscount()));
        saleRepository.save(sale);

        saleItemRepository.delete(item);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getSaleCustomer(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));

        if (sale.getCustomer() == null) {
            return Map.of("message", "No customer assigned to this sale");
        }

        Customer customer = sale.getCustomer();
        Map<String, Object> result = new HashMap<>();
        result.put("id", customer.getId());
        result.put("firstName", customer.getFirstName());
        result.put("lastName", customer.getLastName());
        result.put("fullName", customer.getFirstName() + " " + customer.getLastName());
        result.put("email", customer.getEmail());
        result.put("phone", customer.getPhone());
        result.put("loyaltyPoints", customer.getLoyaltyPoints());
        return result;
    }

    @Override
    public SaleDTO assignToCustomer(Long saleId, Long customerId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
        sale.setCustomer(customer);
        return mapToDTO(saleRepository.save(sale));
    }

    @Override
    public SaleDTO removeCustomer(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));
        sale.setCustomer(null);
        return mapToDTO(saleRepository.save(sale));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getSalePayments(Long saleId) {
        return paymentRepository.findBySaleId(saleId).stream().map(payment -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", payment.getId());
            map.put("amount", payment.getAmount());
            map.put("paymentMethod", payment.getPaymentMethod());
            map.put("status", payment.getStatus());
            map.put("createdAt", payment.getCreatedAt());
            return map;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getSaleTotal(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));
        return sale.getTotal();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getDailySalesSummary(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);

        Long totalTransactions = saleRepository.getTotalTransactionsByDateRange(start, end);
        BigDecimal grossSales = saleRepository.getTotalSalesByDateRange(start, end);

        Map<String, Object> summary = new HashMap<>();
        summary.put("date", date);
        summary.put("totalTransactions", totalTransactions);
        summary.put("grossSales", grossSales);
        summary.put("averageTransactionValue", totalTransactions > 0
                ? grossSales.divide(BigDecimal.valueOf(totalTransactions), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO);
        return summary;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getSalesByUser(Long userId) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "createdAt"));
        return saleRepository.searchSales(null, null, userId, null, null, null, null, pageable)
                .getContent()
                .stream()
                .map(this::mapToSummaryDTO)
                .collect(Collectors.toList());
    }

    private SaleDTO mapToDTO(Sale sale) {
        List<SaleDTO.SaleItemDTO> items = sale.getSaleItems() != null
                ? sale.getSaleItems().stream().map(item -> SaleDTO.SaleItemDTO.builder()
                        .id(item.getId())
                        .productId(item.getProduct().getId())
                        .productName(item.getProduct().getName())
                        .barcode(item.getProduct().getBarcode())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())
                        .discount(item.getDiscount())
                        .total(item.getTotal())
                        .build()).collect(Collectors.toList())
                : List.of();

        return SaleDTO.builder()
                .id(sale.getId())
                .invoiceNumber(sale.getInvoiceNumber())
                .customerId(sale.getCustomer() != null ? sale.getCustomer().getId() : null)
                .customerName(sale.getCustomer() != null ? sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName() : null)
                .userId(sale.getUser() != null ? sale.getUser().getId() : null)
                .cashierName(sale.getUser() != null ? sale.getUser().getUsername() : null)
                .items(items)
                .subtotal(sale.getSubtotal())
                .tax(sale.getTax())
                .discount(sale.getDiscount())
                .total(sale.getTotal())
                .amountPaid(sale.getAmountPaid())
                .changeAmount(sale.getChangeAmount())
                .paymentMethod(sale.getPaymentMethod())
                .status(sale.getStatus())
                .notes(sale.getNotes())
                .build();
    }

    private SaleSummaryDTO mapToSummaryDTO(Sale sale) {
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

    private SaleItemResponse mapToItemResponse(SaleItem item) {
        return SaleItemResponse.builder()
                .id(item.getId())
                .productId(item.getProduct().getId())
                .productName(item.getProduct().getName())
                .barcode(item.getProduct().getBarcode())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .discount(item.getDiscount())
                .total(item.getTotal())
                .build();
    }
}
