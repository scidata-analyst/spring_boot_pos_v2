package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;
import java.util.List;

/**
 * Service interface for Categories.
 * Defines standard CRUD operations for Categories, same as Controller methods.
 */
public interface CategoriesService {

    /**
     * Retrieve all Categories records.
     * @return List of CategoriesResponse
     */
    List<CategoriesResponse> getAll();

    /**
     * Retrieve a single Categories by its ID.
     * @param id ID of the Categories
     * @return CategoriesResponse object
     */
    CategoriesResponse get(Long id);

    /**
     * Create a new Categories record.
     * @param request DTO containing the Categories data
     * @return Created CategoriesResponse
     */
    CategoriesResponse create(CategoriesRequest request);

    /**
     * Update an existing Categories by its ID.
     * @param id ID of the Categories to update
     * @param request DTO containing updated data
     * @return Updated CategoriesResponse
     */
    CategoriesResponse update(Long id, CategoriesRequest request);

    /**
     * Delete a Categories by its ID.
     * @param id ID of the Categories to delete
     */
    void delete(Long id);
}
