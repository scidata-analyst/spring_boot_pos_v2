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
 * Provides standard CRUD APIs for RestockAlerts.
 * All responses are returned using RestockAlertsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Suppliers/RestockAlerts
 * - GET    /api/Suppliers/RestockAlerts/{id}
 * - POST   /api/Suppliers/RestockAlerts
 * - PUT    /api/Suppliers/RestockAlerts/{id}
 * - DELETE /api/Suppliers/RestockAlerts/{id}
 */
@RestController
@RequestMapping("/api/Suppliers/RestockAlerts")
public class RestockAlertsController {

    @Autowired
    private RestockAlertsService service;

    /**
     * Retrieve all RestockAlerts records.
     *
     * @return List of RestockAlertsResponse
     */
    @GetMapping
    public List<RestockAlertsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single RestockAlerts by ID.
     *
     * @param id ID of the RestockAlerts
     * @return RestockAlertsResponse
     */
    @GetMapping("/{id}")
    public RestockAlertsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new RestockAlerts record.
     *
     * @param request request DTO
     * @return created RestockAlertsResponse
     */
    @PostMapping
    public RestockAlertsResponse create(@RequestBody @Valid RestockAlertsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing RestockAlerts record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated RestockAlertsResponse
     */
    @PutMapping("/{id}")
    public RestockAlertsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid RestockAlertsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a RestockAlerts record.
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
