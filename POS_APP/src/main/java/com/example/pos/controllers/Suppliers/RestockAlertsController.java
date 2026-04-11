package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;
import com.example.pos.services.Suppliers.RestockAlertsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: RestockAlerts
 * =====================================================
 *
 * Provides standard REST APIs for RestockAlerts.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Suppliers/RestockAlerts")
public class RestockAlertsController {

    @Autowired
    private RestockAlertsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<RestockAlertsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<RestockAlertsResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public RestockAlertsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public RestockAlertsResponse create(@RequestBody @Valid RestockAlertsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public RestockAlertsResponse update(@PathVariable Long id,
            @RequestBody @Valid RestockAlertsRequest request) {
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
