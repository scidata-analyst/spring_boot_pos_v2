package com.example.pos.controllers.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.ReconciliationRequest;
import com.example.pos.dtos.response.PaymentAccounting.ReconciliationResponse;
import com.example.pos.services.PaymentAccounting.ReconciliationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: Reconciliation
 * =====================================================
 *
 * Provides standard REST APIs for Reconciliation.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/PaymentAccounting/Reconciliation")
public class ReconciliationController {

    @Autowired
    private ReconciliationService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<ReconciliationResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<ReconciliationResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public ReconciliationResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public ReconciliationResponse create(@RequestBody @Valid ReconciliationRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public ReconciliationResponse update(@PathVariable Long id,
            @RequestBody @Valid ReconciliationRequest request) {
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
