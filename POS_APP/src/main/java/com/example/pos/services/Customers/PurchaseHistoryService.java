package com.example.pos.services.Customers;

import com.example.pos.dtos.request.Customers.PurchaseHistoryRequest;
import com.example.pos.dtos.response.Customers.PurchaseHistoryResponse;
import java.util.List;

/**
 * Service interface for PurchaseHistory.
 * Defines standard CRUD operations for PurchaseHistory, same as Controller methods.
 */
public interface PurchaseHistoryService {

    /**
     * Retrieve all PurchaseHistory records.
     * @return List of PurchaseHistoryResponse
     */
    List<PurchaseHistoryResponse> getAll();

    /**
     * Retrieve a single PurchaseHistory by its ID.
     * @param id ID of the PurchaseHistory
     * @return PurchaseHistoryResponse object
     */
    PurchaseHistoryResponse get(Long id);

    /**
     * Create a new PurchaseHistory record.
     * @param request DTO containing the PurchaseHistory data
     * @return Created PurchaseHistoryResponse
     */
    PurchaseHistoryResponse create(PurchaseHistoryRequest request);

    /**
     * Update an existing PurchaseHistory by its ID.
     * @param id ID of the PurchaseHistory to update
     * @param request DTO containing updated data
     * @return Updated PurchaseHistoryResponse
     */
    PurchaseHistoryResponse update(Long id, PurchaseHistoryRequest request);

    /**
     * Delete a PurchaseHistory by its ID.
     * @param id ID of the PurchaseHistory to delete
     */
    void delete(Long id);
}
