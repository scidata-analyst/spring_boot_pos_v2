package com.example.pos.controllers.Users;

import com.example.pos.dtos.request.Users.RolesRequest;
import com.example.pos.dtos.response.Users.RolesResponse;
import com.example.pos.services.Users.RolesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Roles operations.
 * Provides standard CRUD endpoints for Roles.
 * All responses are returned using RolesResponse DTO.
 */
@RestController
@RequestMapping(""/api/Users/Roles"")
public class RolesController {

    @Autowired
    private RolesService service;

    /**
     * Retrieve all Roles records.
     * @return List of RolesResponse
     */
    @GetMapping
    public List<RolesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Roles by its ID.
     * @param id ID of the Roles
     * @return RolesResponse object
     */
    @GetMapping(""/{id}"")
    public RolesResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Roles record.
     * @param request DTO containing the Roles data
     * @return Created RolesResponse
     */
    @PostMapping
    public RolesResponse create(@RequestBody @Valid RolesRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Roles by its ID.
     * @param id ID of the Roles to update
     * @param request DTO containing updated data
     * @return Updated RolesResponse
     */
    @PutMapping(""/{id}"")
    public RolesResponse update(@PathVariable Long id, @RequestBody @Valid RolesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Roles by its ID.
     * @param id ID of the Roles to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
