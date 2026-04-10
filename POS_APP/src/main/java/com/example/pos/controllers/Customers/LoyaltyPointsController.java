package com.example.pos.controllers.Customers;

import com.example.pos.dtos.request.Customers.LoyaltyPointsRequest;
import com.example.pos.dtos.response.Customers.LoyaltyPointsResponse;
import com.example.pos.services.Customers.LoyaltyPointsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing LoyaltyPoints operations.
 * Provides standard CRUD endpoints for LoyaltyPoints.
 * All responses are returned using LoyaltyPointsResponse DTO.
 */
@RestController
@RequestMapping("/api/Customers/LoyaltyPoints")
public class LoyaltyPointsController {

    @Autowired
    private LoyaltyPointsService service;

    /**
     * Retrieve all LoyaltyPoints records.
     * 
     * @return List of LoyaltyPointsResponse
     */
    @GetMapping
    public List<LoyaltyPointsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single LoyaltyPoints by its ID.
     * 
     * @param id ID of the LoyaltyPoints
     * @return LoyaltyPointsResponse object
     */
    @GetMapping("/{id}")
    public LoyaltyPointsResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new LoyaltyPoints record.
     * 
     * @param request DTO containing the LoyaltyPoints data
     * @return Created LoyaltyPointsResponse
     */
    @PostMapping
    public LoyaltyPointsResponse create(@RequestBody @Valid LoyaltyPointsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing LoyaltyPoints by its ID.
     * 
     * @param id      ID of the LoyaltyPoints to update
     * @param request DTO containing updated data
     * @return Updated LoyaltyPointsResponse
     */
    @PutMapping("/{id}")
    public LoyaltyPointsResponse update(@PathVariable Long id, @RequestBody @Valid LoyaltyPointsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a LoyaltyPoints by its ID.
     * 
     * @param id ID of the LoyaltyPoints to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
