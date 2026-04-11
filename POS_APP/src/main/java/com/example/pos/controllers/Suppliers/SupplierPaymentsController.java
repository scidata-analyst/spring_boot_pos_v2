package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;
import com.example.pos.services.Suppliers.SupplierPaymentsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: SupplierPayments
 * =====================================================
 *
 * Provides standard REST APIs for SupplierPayments.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Suppliers/SupplierPayments")
public class SupplierPaymentsController {

    @Autowired
    private SupplierPaymentsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<SupplierPaymentsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<SupplierPaymentsResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public SupplierPaymentsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public SupplierPaymentsResponse create(@RequestBody @Valid SupplierPaymentsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public SupplierPaymentsResponse update(@PathVariable Long id,
            @RequestBody @Valid SupplierPaymentsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete record.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
