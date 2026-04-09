package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;
import java.util.List;

/**
 * Service interface for BatchExpiry.
 * Defines standard CRUD operations for BatchExpiry, same as Controller methods.
 */
public interface BatchExpiryService {

    /**
     * Retrieve all BatchExpiry records.
     * @return List of BatchExpiryResponse
     */
    List<BatchExpiryResponse> getAll();

    /**
     * Retrieve a single BatchExpiry by its ID.
     * @param id ID of the BatchExpiry
     * @return BatchExpiryResponse object
     */
    BatchExpiryResponse get(Long id);

    /**
     * Create a new BatchExpiry record.
     * @param request DTO containing the BatchExpiry data
     * @return Created BatchExpiryResponse
     */
    BatchExpiryResponse create(BatchExpiryRequest request);

    /**
     * Update an existing BatchExpiry by its ID.
     * @param id ID of the BatchExpiry to update
     * @param request DTO containing updated data
     * @return Updated BatchExpiryResponse
     */
    BatchExpiryResponse update(Long id, BatchExpiryRequest request);

    /**
     * Delete a BatchExpiry by its ID.
     * @param id ID of the BatchExpiry to delete
     */
    void delete(Long id);
}
