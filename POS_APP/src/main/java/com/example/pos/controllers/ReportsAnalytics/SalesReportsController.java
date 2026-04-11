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
 * Provides standard CRUD APIs for SalesReports.
 * All responses are returned using SalesReportsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/ReportsAnalytics/SalesReports
 * - GET    /api/ReportsAnalytics/SalesReports/{id}
 * - POST   /api/ReportsAnalytics/SalesReports
 * - PUT    /api/ReportsAnalytics/SalesReports/{id}
 * - DELETE /api/ReportsAnalytics/SalesReports/{id}
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/SalesReports")
public class SalesReportsController {

    @Autowired
    private SalesReportsService service;

    /**
     * Retrieve all SalesReports records.
     *
     * @return List of SalesReportsResponse
     */
    @GetMapping
    public List<SalesReportsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single SalesReports by ID.
     *
     * @param id ID of the SalesReports
     * @return SalesReportsResponse
     */
    @GetMapping("/{id}")
    public SalesReportsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new SalesReports record.
     *
     * @param request request DTO
     * @return created SalesReportsResponse
     */
    @PostMapping
    public SalesReportsResponse create(@RequestBody @Valid SalesReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing SalesReports record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated SalesReportsResponse
     */
    @PutMapping("/{id}")
    public SalesReportsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid SalesReportsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a SalesReports record.
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
