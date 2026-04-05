package com.scidata_analyst.pos.controller.customer;

import com.scidata_analyst.pos.dto.customer.CustomerDTO;
import com.scidata_analyst.pos.dto.customer.CustomerPurchaseHistoryDTO;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.request.customer.CreateCustomerRequest;
import com.scidata_analyst.pos.request.customer.SearchCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateLoyaltyPointsRequest;
import com.scidata_analyst.pos.response.customer.LoyaltyPointsResponse;
import com.scidata_analyst.pos.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        CustomerDTO created = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody UpdateCustomerRequest request) {
        CustomerDTO updated = customerService.updateCustomer(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> searchCustomers(SearchCustomerRequest request) {
        Page<CustomerDTO> customers = customerService.searchCustomers(request);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/active")
    public ResponseEntity<List<CustomerDTO>> getAllActiveCustomers() {
        List<CustomerDTO> customers = customerService.getAllActiveCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}/purchase-history")
    public ResponseEntity<CustomerPurchaseHistoryDTO> getPurchaseHistory(@PathVariable Long customerId) {
        CustomerPurchaseHistoryDTO history = customerService.getPurchaseHistory(customerId);
        return ResponseEntity.ok(history);
    }

    @PatchMapping("/loyalty")
    public ResponseEntity<LoyaltyPointsResponse> updateLoyaltyPoints(@Valid @RequestBody UpdateLoyaltyPointsRequest request) {
        LoyaltyPointsResponse response = customerService.updateLoyaltyPoints(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCustomer(@PathVariable Long id) {
        customerService.deactivateCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/sales")
    public ResponseEntity<List<SaleSummaryDTO>> getCustomerSales(@PathVariable Long id) {
        List<SaleSummaryDTO> sales = customerService.getCustomerSales(id);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}/sales/recent")
    public ResponseEntity<List<SaleSummaryDTO>> getCustomerRecentSales(@PathVariable Long id, @RequestParam(defaultValue = "10") Integer limit) {
        List<SaleSummaryDTO> sales = customerService.getCustomerRecentSales(id, limit);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}/sales/summary")
    public ResponseEntity<Map<String, Object>> getCustomerSalesSummary(@PathVariable Long id) {
        Map<String, Object> summary = customerService.getCustomerSalesSummary(id);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/{id}/sales/date-range")
    public ResponseEntity<List<SaleSummaryDTO>> getCustomerSalesByDateRange(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<SaleSummaryDTO> sales = customerService.getCustomerSalesByDateRange(id, startDate, endDate);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/top")
    public ResponseEntity<List<CustomerDTO>> getTopCustomers(@RequestParam(defaultValue = "10") Integer limit) {
        List<CustomerDTO> customers = customerService.getTopCustomers(limit);
        return ResponseEntity.ok(customers);
    }
}
