package com.example.pos.controllers.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;
import com.example.pos.services.LoyaltyMembership.PointsConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: PointsConfig
 * =====================================================
 *
 * Provides standard CRUD APIs for PointsConfig.
 * All responses are returned using PointsConfigResponse DTO.
 *
 * Endpoints:
 * - GET    /api/LoyaltyMembership/PointsConfig
 * - GET    /api/LoyaltyMembership/PointsConfig/{id}
 * - POST   /api/LoyaltyMembership/PointsConfig
 * - PUT    /api/LoyaltyMembership/PointsConfig/{id}
 * - DELETE /api/LoyaltyMembership/PointsConfig/{id}
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/PointsConfig")
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
     * Retrieve a single PointsConfig by ID.
     *
     * @param id ID of the PointsConfig
     * @return PointsConfigResponse
     */
    @GetMapping("/{id}")
    public PointsConfigResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new PointsConfig record.
     *
     * @param request request DTO
     * @return created PointsConfigResponse
     */
    @PostMapping
    public PointsConfigResponse create(@RequestBody @Valid PointsConfigRequest request) {
        return service.create(request);
    }

    /**
     * Update existing PointsConfig record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated PointsConfigResponse
     */
    @PutMapping("/{id}")
    public PointsConfigResponse update(@PathVariable Long id,
                                         @RequestBody @Valid PointsConfigRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PointsConfig record.
     *
     * @param id record ID
     * @return success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
