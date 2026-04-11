package com.example.pos.controllers.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.LoyaltyPointsRequest;
import com.example.pos.dtos.response.CustomersCRM.LoyaltyPointsResponse;
import com.example.pos.services.CustomersCRM.LoyaltyPointsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: LoyaltyPoints
 * =====================================================
 *
 * Provides standard CRUD APIs for LoyaltyPoints.
 * All responses are returned using LoyaltyPointsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/CustomersCRM/LoyaltyPoints
 * - GET    /api/CustomersCRM/LoyaltyPoints/{id}
 * - POST   /api/CustomersCRM/LoyaltyPoints
 * - PUT    /api/CustomersCRM/LoyaltyPoints/{id}
 * - DELETE /api/CustomersCRM/LoyaltyPoints/{id}
 */
@RestController
@RequestMapping("/api/CustomersCRM/LoyaltyPoints")
public class LoyaltyPointsController {

    @Autowired
    private LoyaltyPointsService service;

    /**
     * Retrieve all LoyaltyPoints records.
     *
     * @return List of LoyaltyPointsResponse
     */
    @GetMapping
    public List<LoyaltyPointsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single LoyaltyPoints by ID.
     *
     * @param id ID of the LoyaltyPoints
     * @return LoyaltyPointsResponse
     */
    @GetMapping("/{id}")
    public LoyaltyPointsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new LoyaltyPoints record.
     *
     * @param request request DTO
     * @return created LoyaltyPointsResponse
     */
    @PostMapping
    public LoyaltyPointsResponse create(@RequestBody @Valid LoyaltyPointsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing LoyaltyPoints record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated LoyaltyPointsResponse
     */
    @PutMapping("/{id}")
    public LoyaltyPointsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid LoyaltyPointsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a LoyaltyPoints record.
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
