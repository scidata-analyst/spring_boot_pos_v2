package com.example.pos.controllers.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.PLReportRequest;
import com.example.pos.dtos.response.ReportsAnalytics.PLReportResponse;
import com.example.pos.services.ReportsAnalytics.PLReportService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: PLReport
 * =====================================================
 *
 * Provides standard REST APIs for PLReport.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/PLReport")
public class PLReportController {

    @Autowired
    private PLReportService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<PLReportResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<PLReportResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public PLReportResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public PLReportResponse create(@RequestBody @Valid PLReportRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public PLReportResponse update(@PathVariable Long id,
            @RequestBody @Valid PLReportRequest request) {
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
