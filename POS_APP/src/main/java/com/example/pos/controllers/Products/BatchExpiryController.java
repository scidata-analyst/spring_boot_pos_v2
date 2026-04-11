package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;
import com.example.pos.services.Products.BatchExpiryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: BatchExpiry
 * =====================================================
 *
 * Provides standard CRUD APIs for BatchExpiry.
 * All responses are returned using BatchExpiryResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Products/BatchExpiry
 * - GET    /api/Products/BatchExpiry/{id}
 * - POST   /api/Products/BatchExpiry
 * - PUT    /api/Products/BatchExpiry/{id}
 * - DELETE /api/Products/BatchExpiry/{id}
 */
@RestController
@RequestMapping("/api/Products/BatchExpiry")
public class BatchExpiryController {

    @Autowired
    private BatchExpiryService service;

    /**
     * Retrieve all BatchExpiry records.
     *
     * @return List of BatchExpiryResponse
     */
    @GetMapping
    public List<BatchExpiryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single BatchExpiry by ID.
     *
     * @param id ID of the BatchExpiry
     * @return BatchExpiryResponse
     */
    @GetMapping("/{id}")
    public BatchExpiryResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new BatchExpiry record.
     *
     * @param request request DTO
     * @return created BatchExpiryResponse
     */
    @PostMapping
    public BatchExpiryResponse create(@RequestBody @Valid BatchExpiryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing BatchExpiry record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated BatchExpiryResponse
     */
    @PutMapping("/{id}")
    public BatchExpiryResponse update(@PathVariable Long id,
                                         @RequestBody @Valid BatchExpiryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a BatchExpiry record.
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
