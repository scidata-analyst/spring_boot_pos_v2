package com.example.pos.controllers.Reports;

import com.example.pos.dtos.request.Reports.StockReportRequest;
import com.example.pos.dtos.response.Reports.StockReportResponse;
import com.example.pos.services.Reports.StockReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing StockReport operations.
 * Provides standard CRUD endpoints for StockReport.
 * All responses are returned using StockReportResponse DTO.
 */
@RestController
@RequestMapping("/api/Reports/StockReport")
public class StockReportController {

    @Autowired
    private StockReportService service;

    /**
     * Retrieve all StockReport records.
     * 
     * @return List of StockReportResponse
     */
    @GetMapping
    public List<StockReportResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single StockReport by its ID.
     * 
     * @param id ID of the StockReport
     * @return StockReportResponse object
     */
    @GetMapping("/{id}")
    public StockReportResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new StockReport record.
     * 
     * @param request DTO containing the StockReport data
     * @return Created StockReportResponse
     */
    @PostMapping
    public StockReportResponse create(@RequestBody @Valid StockReportRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing StockReport by its ID.
     * 
     * @param id      ID of the StockReport to update
     * @param request DTO containing updated data
     * @return Updated StockReportResponse
     */
    @PutMapping("/{id}")
    public StockReportResponse update(@PathVariable Long id, @RequestBody @Valid StockReportRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a StockReport by its ID.
     * 
     * @param id ID of the StockReport to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
