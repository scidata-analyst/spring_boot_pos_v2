package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;
import com.example.pos.services.Products.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Categories operations.
 * Provides standard CRUD endpoints for Categories.
 * All responses are returned using CategoriesResponse DTO.
 */
@RestController
@RequestMapping("/api/Products/Categories")
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    /**
     * Retrieve all Categories records.
     * 
     * @return List of CategoriesResponse
     */
    @GetMapping
    public List<CategoriesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Categories by its ID.
     * 
     * @param id ID of the Categories
     * @return CategoriesResponse object
     */
    @GetMapping("/{id}")
    public CategoriesResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Categories record.
     * 
     * @param request DTO containing the Categories data
     * @return Created CategoriesResponse
     */
    @PostMapping
    public CategoriesResponse create(@RequestBody @Valid CategoriesRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Categories by its ID.
     * 
     * @param id      ID of the Categories to update
     * @param request DTO containing updated data
     * @return Updated CategoriesResponse
     */
    @PutMapping("/{id}")
    public CategoriesResponse update(@PathVariable Long id, @RequestBody @Valid CategoriesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Categories by its ID.
     * 
     * @param id ID of the Categories to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
