package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.CatalogRequest;
import com.example.pos.dtos.response.Products.CatalogResponse;
import java.util.List;

/**
 * Service interface for Catalog.
 * Defines standard CRUD operations for Catalog, same as Controller methods.
 */
public interface CatalogService {

    /**
     * Retrieve all Catalog records.
     * @return List of CatalogResponse
     */
    List<CatalogResponse> getAll();

    /**
     * Retrieve a single Catalog by its ID.
     * @param id ID of the Catalog
     * @return CatalogResponse object
     */
    CatalogResponse get(Long id);

    /**
     * Create a new Catalog record.
     * @param request DTO containing the Catalog data
     * @return Created CatalogResponse
     */
    CatalogResponse create(CatalogRequest request);

    /**
     * Update an existing Catalog by its ID.
     * @param id ID of the Catalog to update
     * @param request DTO containing updated data
     * @return Updated CatalogResponse
     */
    CatalogResponse update(Long id, CatalogRequest request);

    /**
     * Delete a Catalog by its ID.
     * @param id ID of the Catalog to delete
     */
    void delete(Long id);
}
