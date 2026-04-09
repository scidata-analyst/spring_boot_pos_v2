package com.example.pos.services.Loyalty;

import com.example.pos.dtos.request.Loyalty.RetentionRequest;
import com.example.pos.dtos.response.Loyalty.RetentionResponse;
import java.util.List;

/**
 * Service interface for Retention.
 * Defines standard CRUD operations for Retention, same as Controller methods.
 */
public interface RetentionService {

    /**
     * Retrieve all Retention records.
     * @return List of RetentionResponse
     */
    List<RetentionResponse> getAll();

    /**
     * Retrieve a single Retention by its ID.
     * @param id ID of the Retention
     * @return RetentionResponse object
     */
    RetentionResponse get(Long id);

    /**
     * Create a new Retention record.
     * @param request DTO containing the Retention data
     * @return Created RetentionResponse
     */
    RetentionResponse create(RetentionRequest request);

    /**
     * Update an existing Retention by its ID.
     * @param id ID of the Retention to update
     * @param request DTO containing updated data
     * @return Updated RetentionResponse
     */
    RetentionResponse update(Long id, RetentionRequest request);

    /**
     * Delete a Retention by its ID.
     * @param id ID of the Retention to delete
     */
    void delete(Long id);
}
