package com.example.pos.controllers.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;
import com.example.pos.services.LoyaltyMembership.PointsConfigService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: PointsConfig
 * =====================================================
 *
 * Provides standard REST APIs for PointsConfig.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/PointsConfig")
public class PointsConfigController {

    @Autowired
    private PointsConfigService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<PointsConfigResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<PointsConfigResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public PointsConfigResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public PointsConfigResponse create(@RequestBody @Valid PointsConfigRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public PointsConfigResponse update(@PathVariable Long id,
            @RequestBody @Valid PointsConfigRequest request) {
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
