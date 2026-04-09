package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.CatalogRequest;
import com.example.pos.dtos.response.Products.CatalogResponse;
import com.example.pos.services.Products.CatalogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Catalog operations.
 * Provides standard CRUD endpoints for Catalog.
 * All responses are returned using CatalogResponse DTO.
 */
@RestController
@RequestMapping(""/api/Products/Catalog"")
public class CatalogController {

    @Autowired
    private CatalogService service;

    /**
     * Retrieve all Catalog records.
     * @return List of CatalogResponse
     */
    @GetMapping
    public List<CatalogResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Catalog by its ID.
     * @param id ID of the Catalog
     * @return CatalogResponse object
     */
    @GetMapping(""/{id}"")
    public CatalogResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Catalog record.
     * @param request DTO containing the Catalog data
     * @return Created CatalogResponse
     */
    @PostMapping
    public CatalogResponse create(@RequestBody @Valid CatalogRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Catalog by its ID.
     * @param id ID of the Catalog to update
     * @param request DTO containing updated data
     * @return Updated CatalogResponse
     */
    @PutMapping(""/{id}"")
    public CatalogResponse update(@PathVariable Long id, @RequestBody @Valid CatalogRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Catalog by its ID.
     * @param id ID of the Catalog to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
