package com.example.pos.controllers.Reports;

import com.example.pos.dtos.request.Reports.SalesReportRequest;
import com.example.pos.dtos.response.Reports.SalesReportResponse;
import com.example.pos.services.Reports.SalesReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing SalesReport operations.
 * Provides standard CRUD endpoints for SalesReport.
 * All responses are returned using SalesReportResponse DTO.
 */
@RestController
@RequestMapping("/api/Reports/SalesReport")
public class SalesReportController {

    @Autowired
    private SalesReportService service;

    /**
     * Retrieve all SalesReport records.
     * 
     * @return List of SalesReportResponse
     */
    @GetMapping
    public List<SalesReportResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single SalesReport by its ID.
     * 
     * @param id ID of the SalesReport
     * @return SalesReportResponse object
     */
    @GetMapping("/{id}")
    public SalesReportResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new SalesReport record.
     * 
     * @param request DTO containing the SalesReport data
     * @return Created SalesReportResponse
     */
    @PostMapping
    public SalesReportResponse create(@RequestBody @Valid SalesReportRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing SalesReport by its ID.
     * 
     * @param id      ID of the SalesReport to update
     * @param request DTO containing updated data
     * @return Updated SalesReportResponse
     */
    @PutMapping("/{id}")
    public SalesReportResponse update(@PathVariable Long id, @RequestBody @Valid SalesReportRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a SalesReport by its ID.
     * 
     * @param id ID of the SalesReport to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
