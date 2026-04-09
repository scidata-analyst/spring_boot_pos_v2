package com.example.pos.services.Promos;

import com.example.pos.dtos.request.Promos.CouponsRequest;
import com.example.pos.dtos.response.Promos.CouponsResponse;
import java.util.List;

/**
 * Service interface for Coupons.
 * Defines standard CRUD operations for Coupons, same as Controller methods.
 */
public interface CouponsService {

    /**
     * Retrieve all Coupons records.
     * @return List of CouponsResponse
     */
    List<CouponsResponse> getAll();

    /**
     * Retrieve a single Coupons by its ID.
     * @param id ID of the Coupons
     * @return CouponsResponse object
     */
    CouponsResponse get(Long id);

    /**
     * Create a new Coupons record.
     * @param request DTO containing the Coupons data
     * @return Created CouponsResponse
     */
    CouponsResponse create(CouponsRequest request);

    /**
     * Update an existing Coupons by its ID.
     * @param id ID of the Coupons to update
     * @param request DTO containing updated data
     * @return Updated CouponsResponse
     */
    CouponsResponse update(Long id, CouponsRequest request);

    /**
     * Delete a Coupons by its ID.
     * @param id ID of the Coupons to delete
     */
    void delete(Long id);
}
