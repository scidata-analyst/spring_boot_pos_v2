package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;
import java.util.List;

/**
 * Service interface for StockMovement.
 * Defines standard CRUD operations for StockMovement, same as Controller methods.
 */
public interface StockMovementService {

    /**
     * Retrieve all StockMovement records.
     * @return List of StockMovementResponse
     */
    List<StockMovementResponse> getAll();

    /**
     * Retrieve a single StockMovement by its ID.
     * @param id ID of the StockMovement
     * @return StockMovementResponse object
     */
    StockMovementResponse get(Long id);

    /**
     * Create a new StockMovement record.
     * @param request DTO containing the StockMovement data
     * @return Created StockMovementResponse
     */
    StockMovementResponse create(StockMovementRequest request);

    /**
     * Update an existing StockMovement by its ID.
     * @param id ID of the StockMovement to update
     * @param request DTO containing updated data
     * @return Updated StockMovementResponse
     */
    StockMovementResponse update(Long id, StockMovementRequest request);

    /**
     * Delete a StockMovement by its ID.
     * @param id ID of the StockMovement to delete
     */
    void delete(Long id);
}
