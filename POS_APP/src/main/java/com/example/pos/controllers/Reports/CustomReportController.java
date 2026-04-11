package com.example.pos.controllers.Reports;

import com.example.pos.dtos.request.Reports.CustomReportRequest;
import com.example.pos.dtos.response.Reports.CustomReportResponse;
import com.example.pos.services.Reports.CustomReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing CustomReport operations.
 * Provides standard CRUD endpoints for CustomReport.
 * All responses are returned using CustomReportResponse DTO.
 */
@RestController
@RequestMapping("/api/Reports/CustomReport")
public class CustomReportController {

    @Autowired
    private CustomReportService service;

    /**
     * Retrieve all CustomReport records.
     * 
     * @return List of CustomReportResponse
     */
    @GetMapping
    public List<CustomReportResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CustomReport by its ID.
     * 
     * @param id ID of the CustomReport
     * @return CustomReportResponse object
     */
    @GetMapping("/{id}")
    public CustomReportResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new CustomReport record.
     * 
     * @param request DTO containing the CustomReport data
     * @return Created CustomReportResponse
     */
    @PostMapping
    public CustomReportResponse create(@RequestBody @Valid CustomReportRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing CustomReport by its ID.
     * 
     * @param id      ID of the CustomReport to update
     * @param request DTO containing updated data
     * @return Updated CustomReportResponse
     */
    @PutMapping("/{id}")
    public CustomReportResponse update(@PathVariable Long id, @RequestBody @Valid CustomReportRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CustomReport by its ID.
     * 
     * @param id ID of the CustomReport to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
