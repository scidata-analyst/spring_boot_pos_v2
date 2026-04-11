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
 * Provides standard CRUD APIs for PLReport.
 * All responses are returned using PLReportResponse DTO.
 *
 * Endpoints:
 * - GET    /api/ReportsAnalytics/PLReport
 * - GET    /api/ReportsAnalytics/PLReport/{id}
 * - POST   /api/ReportsAnalytics/PLReport
 * - PUT    /api/ReportsAnalytics/PLReport/{id}
 * - DELETE /api/ReportsAnalytics/PLReport/{id}
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/PLReport")
public class PLReportController {

    @Autowired
    private PLReportService service;

    /**
     * Retrieve all PLReport records.
     *
     * @return List of PLReportResponse
     */
    @GetMapping
    public List<PLReportResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PLReport by ID.
     *
     * @param id ID of the PLReport
     * @return PLReportResponse
     */
    @GetMapping("/{id}")
    public PLReportResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new PLReport record.
     *
     * @param request request DTO
     * @return created PLReportResponse
     */
    @PostMapping
    public PLReportResponse create(@RequestBody @Valid PLReportRequest request) {
        return service.create(request);
    }

    /**
     * Update existing PLReport record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated PLReportResponse
     */
    @PutMapping("/{id}")
    public PLReportResponse update(@PathVariable Long id,
                                         @RequestBody @Valid PLReportRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PLReport record.
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
