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
 * Provides standard REST APIs for TierManagement.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/TierManagement")
public class TierManagementController {

    @Autowired
    private TierManagementService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<TierManagementResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<TierManagementResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public TierManagementResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public TierManagementResponse create(@RequestBody @Valid TierManagementRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public TierManagementResponse update(@PathVariable Long id,
            @RequestBody @Valid TierManagementRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete record.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
