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
 * Provides standard CRUD APIs for StockReports.
 * All responses are returned using StockReportsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/ReportsAnalytics/StockReports
 * - GET    /api/ReportsAnalytics/StockReports/{id}
 * - POST   /api/ReportsAnalytics/StockReports
 * - PUT    /api/ReportsAnalytics/StockReports/{id}
 * - DELETE /api/ReportsAnalytics/StockReports/{id}
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/StockReports")
public class StockReportsController {

    @Autowired
    private StockReportsService service;

    /**
     * Retrieve all StockReports records.
     *
     * @return List of StockReportsResponse
     */
    @GetMapping
    public List<StockReportsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single StockReports by ID.
     *
     * @param id ID of the StockReports
     * @return StockReportsResponse
     */
    @GetMapping("/{id}")
    public StockReportsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new StockReports record.
     *
     * @param request request DTO
     * @return created StockReportsResponse
     */
    @PostMapping
    public StockReportsResponse create(@RequestBody @Valid StockReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing StockReports record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated StockReportsResponse
     */
    @PutMapping("/{id}")
    public StockReportsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid StockReportsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a StockReports record.
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
