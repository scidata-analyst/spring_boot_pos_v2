package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;
import com.example.pos.services.Products.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: Categories
 * =====================================================
 *
 * Provides standard CRUD APIs for Categories.
 * All responses are returned using CategoriesResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Products/Categories
 * - GET    /api/Products/Categories/{id}
 * - POST   /api/Products/Categories
 * - PUT    /api/Products/Categories/{id}
 * - DELETE /api/Products/Categories/{id}
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
     * Retrieve a single Categories by ID.
     *
     * @param id ID of the Categories
     * @return CategoriesResponse
     */
    @GetMapping("/{id}")
    public CategoriesResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new Categories record.
     *
     * @param request request DTO
     * @return created CategoriesResponse
     */
    @PostMapping
    public CategoriesResponse create(@RequestBody @Valid CategoriesRequest request) {
        return service.create(request);
    }

    /**
     * Update existing Categories record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CategoriesResponse
     */
    @PutMapping("/{id}")
    public CategoriesResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CategoriesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Categories record.
     *
     * @param id record ID
     * @return success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
