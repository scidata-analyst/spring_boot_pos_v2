package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.ProductCatalogRequest;
import com.example.pos.dtos.response.Products.ProductCatalogResponse;
import com.example.pos.services.Products.ProductCatalogService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: ProductCatalog
 * =====================================================
 *
 * Provides standard REST APIs for ProductCatalog.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Products/ProductCatalog")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<ProductCatalogResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<ProductCatalogResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public ProductCatalogResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public ProductCatalogResponse create(@RequestBody @Valid ProductCatalogRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public ProductCatalogResponse update(@PathVariable Long id,
            @RequestBody @Valid ProductCatalogRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete record.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
