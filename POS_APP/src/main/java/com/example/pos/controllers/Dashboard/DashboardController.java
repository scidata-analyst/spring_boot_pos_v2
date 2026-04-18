package com.example.pos.controllers.Dashboard;

import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;
import com.example.pos.services.Dashboard.DashboardService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: Dashboard
 * =====================================================
 *
 * Provides standard REST APIs for Dashboard.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Dashboard/Dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<DashboardResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<DashboardResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public DashboardResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public DashboardResponse create(@RequestBody @Valid DashboardRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public DashboardResponse update(@PathVariable Long id,
            @RequestBody @Valid DashboardRequest request) {
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
