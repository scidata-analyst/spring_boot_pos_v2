package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;
import com.example.pos.services.Products.BatchExpiryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing BatchExpiry operations.
 * Provides standard CRUD endpoints for BatchExpiry.
 * All responses are returned using BatchExpiryResponse DTO.
 */
@RestController
@RequestMapping(""/api/Products/BatchExpiry"")
public class BatchExpiryController {

    @Autowired
    private BatchExpiryService service;

    /**
     * Retrieve all BatchExpiry records.
     * @return List of BatchExpiryResponse
     */
    @GetMapping
    public List<BatchExpiryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single BatchExpiry by its ID.
     * @param id ID of the BatchExpiry
     * @return BatchExpiryResponse object
     */
    @GetMapping(""/{id}"")
    public BatchExpiryResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new BatchExpiry record.
     * @param request DTO containing the BatchExpiry data
     * @return Created BatchExpiryResponse
     */
    @PostMapping
    public BatchExpiryResponse create(@RequestBody @Valid BatchExpiryRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing BatchExpiry by its ID.
     * @param id ID of the BatchExpiry to update
     * @param request DTO containing updated data
     * @return Updated BatchExpiryResponse
     */
    @PutMapping(""/{id}"")
    public BatchExpiryResponse update(@PathVariable Long id, @RequestBody @Valid BatchExpiryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a BatchExpiry by its ID.
     * @param id ID of the BatchExpiry to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
