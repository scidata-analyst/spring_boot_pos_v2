package com.example.pos.services.Users;

import com.example.pos.dtos.request.Users.RolesRequest;
import com.example.pos.dtos.response.Users.RolesResponse;
import java.util.List;

/**
 * Service interface for Roles.
 * Defines standard CRUD operations for Roles, same as Controller methods.
 */
public interface RolesService {

    /**
     * Retrieve all Roles records.
     * @return List of RolesResponse
     */
    List<RolesResponse> getAll();

    /**
     * Retrieve a single Roles by its ID.
     * @param id ID of the Roles
     * @return RolesResponse object
     */
    RolesResponse get(Long id);

    /**
     * Create a new Roles record.
     * @param request DTO containing the Roles data
     * @return Created RolesResponse
     */
    RolesResponse create(RolesRequest request);

    /**
     * Update an existing Roles by its ID.
     * @param id ID of the Roles to update
     * @param request DTO containing updated data
     * @return Updated RolesResponse
     */
    RolesResponse update(Long id, RolesRequest request);

    /**
     * Delete a Roles by its ID.
     * @param id ID of the Roles to delete
     */
    void delete(Long id);
}
