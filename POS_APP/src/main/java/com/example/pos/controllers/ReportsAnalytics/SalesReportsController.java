package com.example.pos.controllers.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.SalesReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.SalesReportsResponse;
import com.example.pos.services.ReportsAnalytics.SalesReportsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: SalesReports
 * =====================================================
 *
 * Provides standard REST APIs for SalesReports.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/SalesReports")
public class SalesReportsController {

    @Autowired
    private SalesReportsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<SalesReportsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<SalesReportsResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public SalesReportsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public SalesReportsResponse create(@RequestBody @Valid SalesReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public SalesReportsResponse update(@PathVariable Long id,
            @RequestBody @Valid SalesReportsRequest request) {
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
