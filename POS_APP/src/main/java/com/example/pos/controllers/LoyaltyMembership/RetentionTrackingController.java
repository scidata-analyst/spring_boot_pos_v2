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
 * Provides standard CRUD APIs for RetentionTracking.
 * All responses are returned using RetentionTrackingResponse DTO.
 *
 * Endpoints:
 * - GET    /api/LoyaltyMembership/RetentionTracking
 * - GET    /api/LoyaltyMembership/RetentionTracking/{id}
 * - POST   /api/LoyaltyMembership/RetentionTracking
 * - PUT    /api/LoyaltyMembership/RetentionTracking/{id}
 * - DELETE /api/LoyaltyMembership/RetentionTracking/{id}
 */
@RestController
@RequestMapping("/api/LoyaltyMembership/RetentionTracking")
public class RetentionTrackingController {

    @Autowired
    private RetentionTrackingService service;

    /**
     * Retrieve all RetentionTracking records.
     *
     * @return List of RetentionTrackingResponse
     */
    @GetMapping
    public List<RetentionTrackingResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single RetentionTracking by ID.
     *
     * @param id ID of the RetentionTracking
     * @return RetentionTrackingResponse
     */
    @GetMapping("/{id}")
    public RetentionTrackingResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new RetentionTracking record.
     *
     * @param request request DTO
     * @return created RetentionTrackingResponse
     */
    @PostMapping
    public RetentionTrackingResponse create(@RequestBody @Valid RetentionTrackingRequest request) {
        return service.create(request);
    }

    /**
     * Update existing RetentionTracking record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated RetentionTrackingResponse
     */
    @PutMapping("/{id}")
    public RetentionTrackingResponse update(@PathVariable Long id,
                                         @RequestBody @Valid RetentionTrackingRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a RetentionTracking record.
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
