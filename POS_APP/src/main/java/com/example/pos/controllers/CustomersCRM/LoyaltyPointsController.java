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
 * Provides standard REST APIs for LoyaltyPoints.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/CustomersCRM/LoyaltyPoints")
public class LoyaltyPointsController {

    @Autowired
    private LoyaltyPointsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<LoyaltyPointsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<LoyaltyPointsResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public LoyaltyPointsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public LoyaltyPointsResponse create(@RequestBody @Valid LoyaltyPointsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public LoyaltyPointsResponse update(@PathVariable Long id,
            @RequestBody @Valid LoyaltyPointsRequest request) {
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
