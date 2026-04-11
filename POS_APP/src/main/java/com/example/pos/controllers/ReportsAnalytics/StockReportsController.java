package com.example.pos.controllers.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.StockReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.StockReportsResponse;
import com.example.pos.services.ReportsAnalytics.StockReportsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: StockReports
 * =====================================================
 *
 * Provides standard REST APIs for StockReports.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/StockReports")
public class StockReportsController {

    @Autowired
    private StockReportsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<StockReportsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<StockReportsResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public StockReportsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public StockReportsResponse create(@RequestBody @Valid StockReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public StockReportsResponse update(@PathVariable Long id,
            @RequestBody @Valid StockReportsRequest request) {
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
