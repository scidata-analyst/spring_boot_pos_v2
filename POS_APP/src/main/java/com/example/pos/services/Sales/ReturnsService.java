package com.example.pos.services.Sales;

import com.example.pos.dtos.request.Sales.ReturnsRequest;
import com.example.pos.dtos.response.Sales.ReturnsResponse;
import java.util.List;

/**
 * Service interface for Returns.
 * Defines standard CRUD operations for Returns, same as Controller methods.
 */
public interface ReturnsService {

    /**
     * Retrieve all Returns records.
     * @return List of ReturnsResponse
     */
    List<ReturnsResponse> getAll();

    /**
     * Retrieve a single Returns by its ID.
     * @param id ID of the Returns
     * @return ReturnsResponse object
     */
    ReturnsResponse get(Long id);

    /**
     * Create a new Returns record.
     * @param request DTO containing the Returns data
     * @return Created ReturnsResponse
     */
    ReturnsResponse create(ReturnsRequest request);

    /**
     * Update an existing Returns by its ID.
     * @param id ID of the Returns to update
     * @param request DTO containing updated data
     * @return Updated ReturnsResponse
     */
    ReturnsResponse update(Long id, ReturnsRequest request);

    /**
     * Delete a Returns by its ID.
     * @param id ID of the Returns to delete
     */
    void delete(Long id);
}
