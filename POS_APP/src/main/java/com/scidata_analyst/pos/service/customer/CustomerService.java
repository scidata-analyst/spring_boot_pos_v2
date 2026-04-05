package com.scidata_analyst.pos.service.customer;

import com.scidata_analyst.pos.dto.customer.CustomerDTO;
import com.scidata_analyst.pos.dto.customer.CustomerPurchaseHistoryDTO;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.request.customer.CreateCustomerRequest;
import com.scidata_analyst.pos.request.customer.SearchCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateLoyaltyPointsRequest;
import com.scidata_analyst.pos.response.customer.LoyaltyPointsResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    CustomerDTO createCustomer(CreateCustomerRequest request);

    CustomerDTO updateCustomer(Long id, UpdateCustomerRequest request);

    CustomerDTO getCustomerById(Long id);

    Page<CustomerDTO> searchCustomers(SearchCustomerRequest request);

    List<CustomerDTO> getAllActiveCustomers();

    CustomerPurchaseHistoryDTO getPurchaseHistory(Long customerId);

    LoyaltyPointsResponse updateLoyaltyPoints(UpdateLoyaltyPointsRequest request);

    void deleteCustomer(Long id);

    void deactivateCustomer(Long id);

    boolean existsByEmail(String email);

    CustomerDTO getCustomerByPhone(String phone);

    List<SaleSummaryDTO> getCustomerSales(Long customerId);

    List<SaleSummaryDTO> getCustomerRecentSales(Long customerId, Integer limit);

    Map<String, Object> getCustomerSalesSummary(Long customerId);

    List<SaleSummaryDTO> getCustomerSalesByDateRange(Long customerId, LocalDate startDate, LocalDate endDate);

    List<CustomerDTO> getTopCustomers(Integer limit);
}
