package com.example.pos.controllers.Accounting;

import com.example.pos.dtos.request.Accounting.TaxReportsRequest;
import com.example.pos.dtos.response.Accounting.TaxReportsResponse;
import com.example.pos.services.Accounting.TaxReportsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing TaxReports operations.
 * Provides standard CRUD endpoints for TaxReports.
 * All responses are returned using TaxReportsResponse DTO.
 */
@RestController
@RequestMapping("/api/Accounting/TaxReports")
public class TaxReportsController {

    @Autowired
    private TaxReportsService service;

    /**
     * Retrieve all TaxReports records.
     * 
     * @return List of TaxReportsResponse
     */
    @GetMapping
    public List<TaxReportsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single TaxReports by its ID.
     * 
     * @param id ID of the TaxReports
     * @return TaxReportsResponse object
     */
    @GetMapping("/{id}")
    public TaxReportsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new TaxReports record.
     * 
     * @param request DTO containing the TaxReports data
     * @return Created TaxReportsResponse
     */
    @PostMapping
    public TaxReportsResponse create(@RequestBody @Valid TaxReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing TaxReports by its ID.
     * 
     * @param id      ID of the TaxReports to update
     * @param request DTO containing updated data
     * @return Updated TaxReportsResponse
     */
    @PutMapping("/{id}")
    public TaxReportsResponse update(@PathVariable Long id, @RequestBody @Valid TaxReportsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a TaxReports by its ID.
     * 
     * @param id ID of the TaxReports to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
