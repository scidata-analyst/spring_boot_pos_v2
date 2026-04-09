package com.example.pos.controllers.Core;

import com.example.pos.dtos.request.Core.DashboardRequest;
import com.example.pos.dtos.response.Core.DashboardResponse;
import com.example.pos.services.Core.DashboardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Dashboard operations.
 * Provides standard CRUD endpoints for Dashboard.
 * All responses are returned using DashboardResponse DTO.
 */
@RestController
@RequestMapping(""/api/Core/Dashboard"")
public class DashboardController {

    @Autowired
    private DashboardService service;

    /**
     * Retrieve all Dashboard records.
     * @return List of DashboardResponse
     */
    @GetMapping
    public List<DashboardResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Dashboard by its ID.
     * @param id ID of the Dashboard
     * @return DashboardResponse object
     */
    @GetMapping(""/{id}"")
    public DashboardResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Dashboard record.
     * @param request DTO containing the Dashboard data
     * @return Created DashboardResponse
     */
    @PostMapping
    public DashboardResponse create(@RequestBody @Valid DashboardRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Dashboard by its ID.
     * @param id ID of the Dashboard to update
     * @param request DTO containing updated data
     * @return Updated DashboardResponse
     */
    @PutMapping(""/{id}"")
    public DashboardResponse update(@PathVariable Long id, @RequestBody @Valid DashboardRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Dashboard by its ID.
     * @param id ID of the Dashboard to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
