package com.example.pos.controllers.Customers;

import com.example.pos.dtos.request.Customers.CustomersRequest;
import com.example.pos.dtos.response.Customers.CustomersResponse;
import com.example.pos.services.Customers.CustomersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Customers operations.
 * Provides standard CRUD endpoints for Customers.
 * All responses are returned using CustomersResponse DTO.
 */
@RestController
@RequestMapping("/api/Customers/Customers")
public class CustomersController {

    @Autowired
    private CustomersService service;

    /**
     * Retrieve all Customers records.
     * 
     * @return List of CustomersResponse
     */
    @GetMapping
    public List<CustomersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Customers by its ID.
     * 
     * @param id ID of the Customers
     * @return CustomersResponse object
     */
    @GetMapping("/{id}")
    public CustomersResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Customers record.
     * 
     * @param request DTO containing the Customers data
     * @return Created CustomersResponse
     */
    @PostMapping
    public CustomersResponse create(@RequestBody @Valid CustomersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Customers by its ID.
     * 
     * @param id      ID of the Customers to update
     * @param request DTO containing updated data
     * @return Updated CustomersResponse
     */
    @PutMapping("/{id}")
    public CustomersResponse update(@PathVariable Long id, @RequestBody @Valid CustomersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Customers by its ID.
     * 
     * @param id ID of the Customers to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
