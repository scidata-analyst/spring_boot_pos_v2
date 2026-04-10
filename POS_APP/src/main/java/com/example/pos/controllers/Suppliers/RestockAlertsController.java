package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;
import com.example.pos.services.Suppliers.RestockAlertsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing RestockAlerts operations.
 * Provides standard CRUD endpoints for RestockAlerts.
 * All responses are returned using RestockAlertsResponse DTO.
 */
@RestController
@RequestMapping("/api/Suppliers/RestockAlerts")
public class RestockAlertsController {

    @Autowired
    private RestockAlertsService service;

    /**
     * Retrieve all RestockAlerts records.
     * 
     * @return List of RestockAlertsResponse
     */
    @GetMapping
    public List<RestockAlertsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single RestockAlerts by its ID.
     * 
     * @param id ID of the RestockAlerts
     * @return RestockAlertsResponse object
     */
    @GetMapping("/{id}")
    public RestockAlertsResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new RestockAlerts record.
     * 
     * @param request DTO containing the RestockAlerts data
     * @return Created RestockAlertsResponse
     */
    @PostMapping
    public RestockAlertsResponse create(@RequestBody @Valid RestockAlertsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing RestockAlerts by its ID.
     * 
     * @param id      ID of the RestockAlerts to update
     * @param request DTO containing updated data
     * @return Updated RestockAlertsResponse
     */
    @PutMapping("/{id}")
    public RestockAlertsResponse update(@PathVariable Long id, @RequestBody @Valid RestockAlertsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a RestockAlerts by its ID.
     * 
     * @param id ID of the RestockAlerts to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
