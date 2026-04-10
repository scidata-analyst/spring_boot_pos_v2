package com.example.pos.controllers.Loyalty;

import com.example.pos.dtos.request.Loyalty.PointsConfigRequest;
import com.example.pos.dtos.response.Loyalty.PointsConfigResponse;
import com.example.pos.services.Loyalty.PointsConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing PointsConfig operations.
 * Provides standard CRUD endpoints for PointsConfig.
 * All responses are returned using PointsConfigResponse DTO.
 */
@RestController
@RequestMapping("/api/Loyalty/PointsConfig")
public class PointsConfigController {

    @Autowired
    private PointsConfigService service;

    /**
     * Retrieve all PointsConfig records.
     * 
     * @return List of PointsConfigResponse
     */
    @GetMapping
    public List<PointsConfigResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PointsConfig by its ID.
     * 
     * @param id ID of the PointsConfig
     * @return PointsConfigResponse object
     */
    @GetMapping("/{id}")
    public PointsConfigResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new PointsConfig record.
     * 
     * @param request DTO containing the PointsConfig data
     * @return Created PointsConfigResponse
     */
    @PostMapping
    public PointsConfigResponse create(@RequestBody @Valid PointsConfigRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing PointsConfig by its ID.
     * 
     * @param id      ID of the PointsConfig to update
     * @param request DTO containing updated data
     * @return Updated PointsConfigResponse
     */
    @PutMapping("/{id}")
    public PointsConfigResponse update(@PathVariable Long id, @RequestBody @Valid PointsConfigRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PointsConfig by its ID.
     * 
     * @param id ID of the PointsConfig to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
