package com.example.pos.services.Customers;

import com.example.pos.dtos.request.Customers.MembershipsRequest;
import com.example.pos.dtos.response.Customers.MembershipsResponse;
import java.util.List;

/**
 * Service interface for Memberships.
 * Defines standard CRUD operations for Memberships, same as Controller methods.
 */
public interface MembershipsService {

    /**
     * Retrieve all Memberships records.
     * @return List of MembershipsResponse
     */
    List<MembershipsResponse> getAll();

    /**
     * Retrieve a single Memberships by its ID.
     * @param id ID of the Memberships
     * @return MembershipsResponse object
     */
    MembershipsResponse get(Long id);

    /**
     * Create a new Memberships record.
     * @param request DTO containing the Memberships data
     * @return Created MembershipsResponse
     */
    MembershipsResponse create(MembershipsRequest request);

    /**
     * Update an existing Memberships by its ID.
     * @param id ID of the Memberships to update
     * @param request DTO containing updated data
     * @return Updated MembershipsResponse
     */
    MembershipsResponse update(Long id, MembershipsRequest request);

    /**
     * Delete a Memberships by its ID.
     * @param id ID of the Memberships to delete
     */
    void delete(Long id);
}
