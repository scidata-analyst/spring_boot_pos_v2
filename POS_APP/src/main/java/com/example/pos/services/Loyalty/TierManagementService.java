package com.example.pos.services.Loyalty;

import com.example.pos.dtos.request.Loyalty.TierManagementRequest;
import com.example.pos.dtos.response.Loyalty.TierManagementResponse;
import java.util.List;

/**
 * Service interface for TierManagement.
 * Defines standard CRUD operations for TierManagement, same as Controller methods.
 */
public interface TierManagementService {

    /**
     * Retrieve all TierManagement records.
     * @return List of TierManagementResponse
     */
    List<TierManagementResponse> getAll();

    /**
     * Retrieve a single TierManagement by its ID.
     * @param id ID of the TierManagement
     * @return TierManagementResponse object
     */
    TierManagementResponse get(Long id);

    /**
     * Create a new TierManagement record.
     * @param request DTO containing the TierManagement data
     * @return Created TierManagementResponse
     */
    TierManagementResponse create(TierManagementRequest request);

    /**
     * Update an existing TierManagement by its ID.
     * @param id ID of the TierManagement to update
     * @param request DTO containing updated data
     * @return Updated TierManagementResponse
     */
    TierManagementResponse update(Long id, TierManagementRequest request);

    /**
     * Delete a TierManagement by its ID.
     * @param id ID of the TierManagement to delete
     */
    void delete(Long id);
}
