package com.example.pos.services.Users;

import com.example.pos.dtos.request.Users.CashiersRequest;
import com.example.pos.dtos.response.Users.CashiersResponse;
import java.util.List;

/**
 * Service interface for Cashiers.
 * Defines standard CRUD operations for Cashiers, same as Controller methods.
 */
public interface CashiersService {

    /**
     * Retrieve all Cashiers records.
     * @return List of CashiersResponse
     */
    List<CashiersResponse> getAll();

    /**
     * Retrieve a single Cashiers by its ID.
     * @param id ID of the Cashiers
     * @return CashiersResponse object
     */
    CashiersResponse get(Long id);

    /**
     * Create a new Cashiers record.
     * @param request DTO containing the Cashiers data
     * @return Created CashiersResponse
     */
    CashiersResponse create(CashiersRequest request);

    /**
     * Update an existing Cashiers by its ID.
     * @param id ID of the Cashiers to update
     * @param request DTO containing updated data
     * @return Updated CashiersResponse
     */
    CashiersResponse update(Long id, CashiersRequest request);

    /**
     * Delete a Cashiers by its ID.
     * @param id ID of the Cashiers to delete
     */
    void delete(Long id);
}
