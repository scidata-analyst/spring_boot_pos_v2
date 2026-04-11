package com.example.pos.controllers.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.RetentionTrackingRequest;
import com.example.pos.dtos.response.LoyaltyMembership.RetentionTrackingResponse;
import com.example.pos.services.LoyaltyMembership.RetentionTrackingService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: RetentionTracking
 * =====================================================
 *
 * Provides standard REST APIs for RetentionTracking.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/RetentionTracking")
public class RetentionTrackingController {

    @Autowired
    private RetentionTrackingService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<RetentionTrackingResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<RetentionTrackingResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public RetentionTrackingResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public RetentionTrackingResponse create(@RequestBody @Valid RetentionTrackingRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public RetentionTrackingResponse update(@PathVariable Long id,
            @RequestBody @Valid RetentionTrackingRequest request) {
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
