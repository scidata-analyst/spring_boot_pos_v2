package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;
import com.example.pos.services.Suppliers.SupplierPaymentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing SupplierPayments operations.
 * Provides standard CRUD endpoints for SupplierPayments.
 * All responses are returned using SupplierPaymentsResponse DTO.
 */
@RestController
@RequestMapping("/api/Suppliers/SupplierPayments")
public class SupplierPaymentsController {

    @Autowired
    private SupplierPaymentsService service;

    /**
     * Retrieve all SupplierPayments records.
     * 
     * @return List of SupplierPaymentsResponse
     */
    @GetMapping
    public List<SupplierPaymentsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single SupplierPayments by its ID.
     * 
     * @param id ID of the SupplierPayments
     * @return SupplierPaymentsResponse object
     */
    @GetMapping("/{id}")
    public SupplierPaymentsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new SupplierPayments record.
     * 
     * @param request DTO containing the SupplierPayments data
     * @return Created SupplierPaymentsResponse
     */
    @PostMapping
    public SupplierPaymentsResponse create(@RequestBody @Valid SupplierPaymentsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing SupplierPayments by its ID.
     * 
     * @param id      ID of the SupplierPayments to update
     * @param request DTO containing updated data
     * @return Updated SupplierPaymentsResponse
     */
    @PutMapping("/{id}")
    public SupplierPaymentsResponse update(@PathVariable Long id, @RequestBody @Valid SupplierPaymentsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a SupplierPayments by its ID.
     * 
     * @param id ID of the SupplierPayments to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
