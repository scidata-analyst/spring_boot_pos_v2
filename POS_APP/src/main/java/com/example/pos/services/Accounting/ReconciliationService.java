package com.example.pos.services.Accounting;

import com.example.pos.dtos.request.Accounting.ReconciliationRequest;
import com.example.pos.dtos.response.Accounting.ReconciliationResponse;
import java.util.List;

/**
 * Service interface for Reconciliation.
 * Defines standard CRUD operations for Reconciliation, same as Controller methods.
 */
public interface ReconciliationService {

    /**
     * Retrieve all Reconciliation records.
     * @return List of ReconciliationResponse
     */
    List<ReconciliationResponse> getAll();

    /**
     * Retrieve a single Reconciliation by its ID.
     * @param id ID of the Reconciliation
     * @return ReconciliationResponse object
     */
    ReconciliationResponse get(Long id);

    /**
     * Create a new Reconciliation record.
     * @param request DTO containing the Reconciliation data
     * @return Created ReconciliationResponse
     */
    ReconciliationResponse create(ReconciliationRequest request);

    /**
     * Update an existing Reconciliation by its ID.
     * @param id ID of the Reconciliation to update
     * @param request DTO containing updated data
     * @return Updated ReconciliationResponse
     */
    ReconciliationResponse update(Long id, ReconciliationRequest request);

    /**
     * Delete a Reconciliation by its ID.
     * @param id ID of the Reconciliation to delete
     */
    void delete(Long id);
}
