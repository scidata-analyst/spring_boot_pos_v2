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
 * Provides standard CRUD APIs for Reconciliation.
 * All responses are returned using ReconciliationResponse DTO.
 *
 * Endpoints:
 * - GET    /api/PaymentAccounting/Reconciliation
 * - GET    /api/PaymentAccounting/Reconciliation/{id}
 * - POST   /api/PaymentAccounting/Reconciliation
 * - PUT    /api/PaymentAccounting/Reconciliation/{id}
 * - DELETE /api/PaymentAccounting/Reconciliation/{id}
 */
@RestController
@RequestMapping("/api/PaymentAccounting/Reconciliation")
public class ReconciliationController {

    @Autowired
    private ReconciliationService service;

    /**
     * Retrieve all Reconciliation records.
     *
     * @return List of ReconciliationResponse
     */
    @GetMapping
    public List<ReconciliationResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Reconciliation by ID.
     *
     * @param id ID of the Reconciliation
     * @return ReconciliationResponse
     */
    @GetMapping("/{id}")
    public ReconciliationResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new Reconciliation record.
     *
     * @param request request DTO
     * @return created ReconciliationResponse
     */
    @PostMapping
    public ReconciliationResponse create(@RequestBody @Valid ReconciliationRequest request) {
        return service.create(request);
    }

    /**
     * Update existing Reconciliation record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated ReconciliationResponse
     */
    @PutMapping("/{id}")
    public ReconciliationResponse update(@PathVariable Long id,
                                         @RequestBody @Valid ReconciliationRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Reconciliation record.
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
