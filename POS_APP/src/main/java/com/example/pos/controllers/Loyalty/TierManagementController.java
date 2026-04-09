package com.example.pos.controllers.Loyalty;

import com.example.pos.dtos.request.Loyalty.TierManagementRequest;
import com.example.pos.dtos.response.Loyalty.TierManagementResponse;
import com.example.pos.services.Loyalty.TierManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing TierManagement operations.
 * Provides standard CRUD endpoints for TierManagement.
 * All responses are returned using TierManagementResponse DTO.
 */
@RestController
@RequestMapping(""/api/Loyalty/TierManagement"")
public class TierManagementController {

    @Autowired
    private TierManagementService service;

    /**
     * Retrieve all TierManagement records.
     * @return List of TierManagementResponse
     */
    @GetMapping
    public List<TierManagementResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single TierManagement by its ID.
     * @param id ID of the TierManagement
     * @return TierManagementResponse object
     */
    @GetMapping(""/{id}"")
    public TierManagementResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new TierManagement record.
     * @param request DTO containing the TierManagement data
     * @return Created TierManagementResponse
     */
    @PostMapping
    public TierManagementResponse create(@RequestBody @Valid TierManagementRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing TierManagement by its ID.
     * @param id ID of the TierManagement to update
     * @param request DTO containing updated data
     * @return Updated TierManagementResponse
     */
    @PutMapping(""/{id}"")
    public TierManagementResponse update(@PathVariable Long id, @RequestBody @Valid TierManagementRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a TierManagement by its ID.
     * @param id ID of the TierManagement to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
