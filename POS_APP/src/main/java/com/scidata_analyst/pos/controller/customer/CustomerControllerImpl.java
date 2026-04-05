package com.scidata_analyst.pos.controller.customer;

import com.scidata_analyst.pos.dto.customer.CustomerDTO;
import com.scidata_analyst.pos.dto.customer.CustomerPurchaseHistoryDTO;
import com.scidata_analyst.pos.request.customer.CreateCustomerRequest;
import com.scidata_analyst.pos.request.customer.SearchCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateCustomerRequest;
import com.scidata_analyst.pos.request.customer.UpdateLoyaltyPointsRequest;
import com.scidata_analyst.pos.response.customer.LoyaltyPointsResponse;
import com.scidata_analyst.pos.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @Override
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        CustomerDTO created = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody UpdateCustomerRequest request) {
        CustomerDTO updated = customerService.updateCustomer(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> searchCustomers(SearchCustomerRequest request) {
        Page<CustomerDTO> customers = customerService.searchCustomers(request);
        return ResponseEntity.ok(customers);
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<CustomerDTO>> getAllActiveCustomers() {
        List<CustomerDTO> customers = customerService.getAllActiveCustomers();
        return ResponseEntity.ok(customers);
    }

    @Override
    @GetMapping("/{customerId}/purchase-history")
    public ResponseEntity<CustomerPurchaseHistoryDTO> getPurchaseHistory(@PathVariable Long customerId) {
        CustomerPurchaseHistoryDTO history = customerService.getPurchaseHistory(customerId);
        return ResponseEntity.ok(history);
    }

    @Override
    @PatchMapping("/loyalty")
    public ResponseEntity<LoyaltyPointsResponse> updateLoyaltyPoints(@Valid @RequestBody UpdateLoyaltyPointsRequest request) {
        LoyaltyPointsResponse response = customerService.updateLoyaltyPoints(request);
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCustomer(@PathVariable Long id) {
        customerService.deactivateCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
