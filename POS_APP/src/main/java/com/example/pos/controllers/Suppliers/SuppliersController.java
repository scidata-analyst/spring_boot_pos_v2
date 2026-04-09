package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.SuppliersRequest;
import com.example.pos.dtos.response.Suppliers.SuppliersResponse;
import com.example.pos.services.Suppliers.SuppliersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Suppliers operations.
 * Provides standard CRUD endpoints for Suppliers.
 * All responses are returned using SuppliersResponse DTO.
 */
@RestController
@RequestMapping(""/api/Suppliers/Suppliers"")
public class SuppliersController {

    @Autowired
    private SuppliersService service;

    /**
     * Retrieve all Suppliers records.
     * @return List of SuppliersResponse
     */
    @GetMapping
    public List<SuppliersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Suppliers by its ID.
     * @param id ID of the Suppliers
     * @return SuppliersResponse object
     */
    @GetMapping(""/{id}"")
    public SuppliersResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Suppliers record.
     * @param request DTO containing the Suppliers data
     * @return Created SuppliersResponse
     */
    @PostMapping
    public SuppliersResponse create(@RequestBody @Valid SuppliersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Suppliers by its ID.
     * @param id ID of the Suppliers to update
     * @param request DTO containing updated data
     * @return Updated SuppliersResponse
     */
    @PutMapping(""/{id}"")
    public SuppliersResponse update(@PathVariable Long id, @RequestBody @Valid SuppliersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Suppliers by its ID.
     * @param id ID of the Suppliers to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
