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
 * Provides standard REST APIs for BatchExpiry.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Products/BatchExpiry")
public class BatchExpiryController {

    @Autowired
    private BatchExpiryService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<BatchExpiryResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<BatchExpiryResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public BatchExpiryResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public BatchExpiryResponse create(@RequestBody @Valid BatchExpiryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public BatchExpiryResponse update(@PathVariable Long id,
            @RequestBody @Valid BatchExpiryRequest request) {
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
