package com.example.pos.controllers.Payment;

import com.example.pos.dtos.request.Payment.ReconciliationRequest;
import com.example.pos.dtos.response.Payment.ReconciliationResponse;
import com.example.pos.services.Payment.ReconciliationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Reconciliation operations.
 * Provides standard CRUD endpoints for Reconciliation.
 * All responses are returned using ReconciliationResponse DTO.
 */
@RestController
@RequestMapping(""/api/Payment/Reconciliation"")
public class ReconciliationController {

    @Autowired
    private ReconciliationService service;

    /**
     * Retrieve all Reconciliation records.
     * @return List of ReconciliationResponse
     */
    @GetMapping
    public List<ReconciliationResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Reconciliation by its ID.
     * @param id ID of the Reconciliation
     * @return ReconciliationResponse object
     */
    @GetMapping(""/{id}"")
    public ReconciliationResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Reconciliation record.
     * @param request DTO containing the Reconciliation data
     * @return Created ReconciliationResponse
     */
    @PostMapping
    public ReconciliationResponse create(@RequestBody @Valid ReconciliationRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Reconciliation by its ID.
     * @param id ID of the Reconciliation to update
     * @param request DTO containing updated data
     * @return Updated ReconciliationResponse
     */
    @PutMapping(""/{id}"")
    public ReconciliationResponse update(@PathVariable Long id, @RequestBody @Valid ReconciliationRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Reconciliation by its ID.
     * @param id ID of the Reconciliation to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
