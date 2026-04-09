package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.SuppliersRequest;
import com.example.pos.dtos.response.Suppliers.SuppliersResponse;
import java.util.List;

/**
 * Service interface for Suppliers.
 * Defines standard CRUD operations for Suppliers, same as Controller methods.
 */
public interface SuppliersService {

    /**
     * Retrieve all Suppliers records.
     * @return List of SuppliersResponse
     */
    List<SuppliersResponse> getAll();

    /**
     * Retrieve a single Suppliers by its ID.
     * @param id ID of the Suppliers
     * @return SuppliersResponse object
     */
    SuppliersResponse get(Long id);

    /**
     * Create a new Suppliers record.
     * @param request DTO containing the Suppliers data
     * @return Created SuppliersResponse
     */
    SuppliersResponse create(SuppliersRequest request);

    /**
     * Update an existing Suppliers by its ID.
     * @param id ID of the Suppliers to update
     * @param request DTO containing updated data
     * @return Updated SuppliersResponse
     */
    SuppliersResponse update(Long id, SuppliersRequest request);

    /**
     * Delete a Suppliers by its ID.
     * @param id ID of the Suppliers to delete
     */
    void delete(Long id);
}
