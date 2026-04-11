package com.example.pos.controllers.Customers;

import com.example.pos.dtos.request.Customers.MembershipsRequest;
import com.example.pos.dtos.response.Customers.MembershipsResponse;
import com.example.pos.services.Customers.MembershipsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Memberships operations.
 * Provides standard CRUD endpoints for Memberships.
 * All responses are returned using MembershipsResponse DTO.
 */
@RestController
@RequestMapping("/api/Customers/Memberships")
public class MembershipsController {

    @Autowired
    private MembershipsService service;

    /**
     * Retrieve all Memberships records.
     * 
     * @return List of MembershipsResponse
     */
    @GetMapping
    public List<MembershipsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Memberships by its ID.
     * 
     * @param id ID of the Memberships
     * @return MembershipsResponse object
     */
    @GetMapping("/{id}")
    public MembershipsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Memberships record.
     * 
     * @param request DTO containing the Memberships data
     * @return Created MembershipsResponse
     */
    @PostMapping
    public MembershipsResponse create(@RequestBody @Valid MembershipsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Memberships by its ID.
     * 
     * @param id      ID of the Memberships to update
     * @param request DTO containing updated data
     * @return Updated MembershipsResponse
     */
    @PutMapping("/{id}")
    public MembershipsResponse update(@PathVariable Long id, @RequestBody @Valid MembershipsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Memberships by its ID.
     * 
     * @param id ID of the Memberships to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
