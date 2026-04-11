package com.example.pos.controllers.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.TierManagementRequest;
import com.example.pos.dtos.response.LoyaltyMembership.TierManagementResponse;
import com.example.pos.services.LoyaltyMembership.TierManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: TierManagement
 * =====================================================
 *
 * Provides standard CRUD APIs for TierManagement.
 * All responses are returned using TierManagementResponse DTO.
 *
 * Endpoints:
 * - GET    /api/LoyaltyMembership/TierManagement
 * - GET    /api/LoyaltyMembership/TierManagement/{id}
 * - POST   /api/LoyaltyMembership/TierManagement
 * - PUT    /api/LoyaltyMembership/TierManagement/{id}
 * - DELETE /api/LoyaltyMembership/TierManagement/{id}
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/TierManagement")
public class TierManagementController {

    @Autowired
    private TierManagementService service;

    /**
     * Retrieve all TierManagement records.
     *
     * @return List of TierManagementResponse
     */
    @GetMapping
    public List<TierManagementResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single TierManagement by ID.
     *
     * @param id ID of the TierManagement
     * @return TierManagementResponse
     */
    @GetMapping("/{id}")
    public TierManagementResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new TierManagement record.
     *
     * @param request request DTO
     * @return created TierManagementResponse
     */
    @PostMapping
    public TierManagementResponse create(@RequestBody @Valid TierManagementRequest request) {
        return service.create(request);
    }

    /**
     * Update existing TierManagement record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated TierManagementResponse
     */
    @PutMapping("/{id}")
    public TierManagementResponse update(@PathVariable Long id,
                                         @RequestBody @Valid TierManagementRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a TierManagement record.
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
