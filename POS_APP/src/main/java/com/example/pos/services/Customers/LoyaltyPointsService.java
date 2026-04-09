package com.example.pos.services.Customers;

import com.example.pos.dtos.request.Customers.LoyaltyPointsRequest;
import com.example.pos.dtos.response.Customers.LoyaltyPointsResponse;
import java.util.List;

/**
 * Service interface for LoyaltyPoints.
 * Defines standard CRUD operations for LoyaltyPoints, same as Controller methods.
 */
public interface LoyaltyPointsService {

    /**
     * Retrieve all LoyaltyPoints records.
     * @return List of LoyaltyPointsResponse
     */
    List<LoyaltyPointsResponse> getAll();

    /**
     * Retrieve a single LoyaltyPoints by its ID.
     * @param id ID of the LoyaltyPoints
     * @return LoyaltyPointsResponse object
     */
    LoyaltyPointsResponse get(Long id);

    /**
     * Create a new LoyaltyPoints record.
     * @param request DTO containing the LoyaltyPoints data
     * @return Created LoyaltyPointsResponse
     */
    LoyaltyPointsResponse create(LoyaltyPointsRequest request);

    /**
     * Update an existing LoyaltyPoints by its ID.
     * @param id ID of the LoyaltyPoints to update
     * @param request DTO containing updated data
     * @return Updated LoyaltyPointsResponse
     */
    LoyaltyPointsResponse update(Long id, LoyaltyPointsRequest request);

    /**
     * Delete a LoyaltyPoints by its ID.
     * @param id ID of the LoyaltyPoints to delete
     */
    void delete(Long id);
}
