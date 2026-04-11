package com.example.pos.controllers.Dashboard;

import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;
import com.example.pos.services.Dashboard.DashboardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: Dashboard
 * =====================================================
 *
 * Provides standard CRUD APIs for Dashboard.
 * All responses are returned using DashboardResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Dashboard/Dashboard
 * - GET    /api/Dashboard/Dashboard/{id}
 * - POST   /api/Dashboard/Dashboard
 * - PUT    /api/Dashboard/Dashboard/{id}
 * - DELETE /api/Dashboard/Dashboard/{id}
 */
@RestController
@RequestMapping("/api/Dashboard/Dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    /**
     * Retrieve all Dashboard records.
     *
     * @return List of DashboardResponse
     */
    @GetMapping
    public List<DashboardResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Dashboard by ID.
     *
     * @param id ID of the Dashboard
     * @return DashboardResponse
     */
    @GetMapping("/{id}")
    public DashboardResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new Dashboard record.
     *
     * @param request request DTO
     * @return created DashboardResponse
     */
    @PostMapping
    public DashboardResponse create(@RequestBody @Valid DashboardRequest request) {
        return service.create(request);
    }

    /**
     * Update existing Dashboard record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated DashboardResponse
     */
    @PutMapping("/{id}")
    public DashboardResponse update(@PathVariable Long id,
                                         @RequestBody @Valid DashboardRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Dashboard record.
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
