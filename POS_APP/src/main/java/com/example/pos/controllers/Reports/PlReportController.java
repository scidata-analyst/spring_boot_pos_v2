package com.example.pos.controllers.Reports;

import com.example.pos.dtos.request.Reports.PlReportRequest;
import com.example.pos.dtos.response.Reports.PlReportResponse;
import com.example.pos.services.Reports.PlReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing PlReport operations.
 * Provides standard CRUD endpoints for PlReport.
 * All responses are returned using PlReportResponse DTO.
 */
@RestController
@RequestMapping("/api/Reports/PlReport")
public class PlReportController {

    @Autowired
    private PlReportService service;

    /**
     * Retrieve all PlReport records.
     * 
     * @return List of PlReportResponse
     */
    @GetMapping
    public List<PlReportResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PlReport by its ID.
     * 
     * @param id ID of the PlReport
     * @return PlReportResponse object
     */
    @GetMapping("/{id}")
    public PlReportResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new PlReport record.
     * 
     * @param request DTO containing the PlReport data
     * @return Created PlReportResponse
     */
    @PostMapping
    public PlReportResponse create(@RequestBody @Valid PlReportRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing PlReport by its ID.
     * 
     * @param id      ID of the PlReport to update
     * @param request DTO containing updated data
     * @return Updated PlReportResponse
     */
    @PutMapping("/{id}")
    public PlReportResponse update(@PathVariable Long id, @RequestBody @Valid PlReportRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PlReport by its ID.
     * 
     * @param id ID of the PlReport to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
