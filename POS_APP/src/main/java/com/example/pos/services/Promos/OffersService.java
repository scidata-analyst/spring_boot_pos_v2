package com.example.pos.services.Promos;

import com.example.pos.dtos.request.Promos.OffersRequest;
import com.example.pos.dtos.response.Promos.OffersResponse;
import java.util.List;

/**
 * Service interface for Offers.
 * Defines standard CRUD operations for Offers, same as Controller methods.
 */
public interface OffersService {

    /**
     * Retrieve all Offers records.
     * @return List of OffersResponse
     */
    List<OffersResponse> getAll();

    /**
     * Retrieve a single Offers by its ID.
     * @param id ID of the Offers
     * @return OffersResponse object
     */
    OffersResponse get(Long id);

    /**
     * Create a new Offers record.
     * @param request DTO containing the Offers data
     * @return Created OffersResponse
     */
    OffersResponse create(OffersRequest request);

    /**
     * Update an existing Offers by its ID.
     * @param id ID of the Offers to update
     * @param request DTO containing updated data
     * @return Updated OffersResponse
     */
    OffersResponse update(Long id, OffersRequest request);

    /**
     * Delete a Offers by its ID.
     * @param id ID of the Offers to delete
     */
    void delete(Long id);
}
