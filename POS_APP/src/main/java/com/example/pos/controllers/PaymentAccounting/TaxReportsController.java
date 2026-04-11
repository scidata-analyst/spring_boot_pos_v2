package com.example.pos.controllers.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.TaxReportsRequest;
import com.example.pos.dtos.response.PaymentAccounting.TaxReportsResponse;
import com.example.pos.services.PaymentAccounting.TaxReportsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: TaxReports
 * =====================================================
 *
 * Provides standard CRUD APIs for TaxReports.
 * All responses are returned using TaxReportsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/PaymentAccounting/TaxReports
 * - GET    /api/PaymentAccounting/TaxReports/{id}
 * - POST   /api/PaymentAccounting/TaxReports
 * - PUT    /api/PaymentAccounting/TaxReports/{id}
 * - DELETE /api/PaymentAccounting/TaxReports/{id}
 */
@RestController
@RequestMapping("/api/PaymentAccounting/TaxReports")
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
     * Retrieve a single TaxReports by ID.
     *
     * @param id ID of the TaxReports
     * @return TaxReportsResponse
     */
    @GetMapping("/{id}")
    public TaxReportsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new TaxReports record.
     *
     * @param request request DTO
     * @return created TaxReportsResponse
     */
    @PostMapping
    public TaxReportsResponse create(@RequestBody @Valid TaxReportsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing TaxReports record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated TaxReportsResponse
     */
    @PutMapping("/{id}")
    public TaxReportsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid TaxReportsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a TaxReports record.
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
