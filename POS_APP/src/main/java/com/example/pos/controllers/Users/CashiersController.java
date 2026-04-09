package com.example.pos.controllers.Users;

import com.example.pos.dtos.request.Users.CashiersRequest;
import com.example.pos.dtos.response.Users.CashiersResponse;
import com.example.pos.services.Users.CashiersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Cashiers operations.
 * Provides standard CRUD endpoints for Cashiers.
 * All responses are returned using CashiersResponse DTO.
 */
@RestController
@RequestMapping(""/api/Users/Cashiers"")
public class CashiersController {

    @Autowired
    private CashiersService service;

    /**
     * Retrieve all Cashiers records.
     * @return List of CashiersResponse
     */
    @GetMapping
    public List<CashiersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Cashiers by its ID.
     * @param id ID of the Cashiers
     * @return CashiersResponse object
     */
    @GetMapping(""/{id}"")
    public CashiersResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Cashiers record.
     * @param request DTO containing the Cashiers data
     * @return Created CashiersResponse
     */
    @PostMapping
    public CashiersResponse create(@RequestBody @Valid CashiersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Cashiers by its ID.
     * @param id ID of the Cashiers to update
     * @param request DTO containing updated data
     * @return Updated CashiersResponse
     */
    @PutMapping(""/{id}"")
    public CashiersResponse update(@PathVariable Long id, @RequestBody @Valid CashiersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Cashiers by its ID.
     * @param id ID of the Cashiers to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
