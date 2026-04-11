package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.ProductCatalogRequest;
import com.example.pos.dtos.response.Products.ProductCatalogResponse;
import com.example.pos.services.Products.ProductCatalogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: ProductCatalog
 * =====================================================
 *
 * Provides standard CRUD APIs for ProductCatalog.
 * All responses are returned using ProductCatalogResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Products/ProductCatalog
 * - GET    /api/Products/ProductCatalog/{id}
 * - POST   /api/Products/ProductCatalog
 * - PUT    /api/Products/ProductCatalog/{id}
 * - DELETE /api/Products/ProductCatalog/{id}
 */
@RestController
@RequestMapping("/api/Products/ProductCatalog")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService service;

    /**
     * Retrieve all ProductCatalog records.
     *
     * @return List of ProductCatalogResponse
     */
    @GetMapping
    public List<ProductCatalogResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single ProductCatalog by ID.
     *
     * @param id ID of the ProductCatalog
     * @return ProductCatalogResponse
     */
    @GetMapping("/{id}")
    public ProductCatalogResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new ProductCatalog record.
     *
     * @param request request DTO
     * @return created ProductCatalogResponse
     */
    @PostMapping
    public ProductCatalogResponse create(@RequestBody @Valid ProductCatalogRequest request) {
        return service.create(request);
    }

    /**
     * Update existing ProductCatalog record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated ProductCatalogResponse
     */
    @PutMapping("/{id}")
    public ProductCatalogResponse update(@PathVariable Long id,
                                         @RequestBody @Valid ProductCatalogRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a ProductCatalog record.
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
