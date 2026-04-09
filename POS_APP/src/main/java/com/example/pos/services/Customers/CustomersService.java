package com.example.pos.services.Customers;

import com.example.pos.dtos.request.Customers.CustomersRequest;
import com.example.pos.dtos.response.Customers.CustomersResponse;
import java.util.List;

/**
 * Service interface for Customers.
 * Defines standard CRUD operations for Customers, same as Controller methods.
 */
public interface CustomersService {

    /**
     * Retrieve all Customers records.
     * @return List of CustomersResponse
     */
    List<CustomersResponse> getAll();

    /**
     * Retrieve a single Customers by its ID.
     * @param id ID of the Customers
     * @return CustomersResponse object
     */
    CustomersResponse get(Long id);

    /**
     * Create a new Customers record.
     * @param request DTO containing the Customers data
     * @return Created CustomersResponse
     */
    CustomersResponse create(CustomersRequest request);

    /**
     * Update an existing Customers by its ID.
     * @param id ID of the Customers to update
     * @param request DTO containing updated data
     * @return Updated CustomersResponse
     */
    CustomersResponse update(Long id, CustomersRequest request);

    /**
     * Delete a Customers by its ID.
     * @param id ID of the Customers to delete
     */
    void delete(Long id);
}
