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
 * Provides standard CRUD APIs for SupplierPayments.
 * All responses are returned using SupplierPaymentsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Suppliers/SupplierPayments
 * - GET    /api/Suppliers/SupplierPayments/{id}
 * - POST   /api/Suppliers/SupplierPayments
 * - PUT    /api/Suppliers/SupplierPayments/{id}
 * - DELETE /api/Suppliers/SupplierPayments/{id}
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
     * Retrieve a single SupplierPayments by ID.
     *
     * @param id ID of the SupplierPayments
     * @return SupplierPaymentsResponse
     */
    @GetMapping("/{id}")
    public SupplierPaymentsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new SupplierPayments record.
     *
     * @param request request DTO
     * @return created SupplierPaymentsResponse
     */
    @PostMapping
    public SupplierPaymentsResponse create(@RequestBody @Valid SupplierPaymentsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing SupplierPayments record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated SupplierPaymentsResponse
     */
    @PutMapping("/{id}")
    public SupplierPaymentsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid SupplierPaymentsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a SupplierPayments record.
     *
     * @param id record ID
     * @return success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
