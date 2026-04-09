package com.example.pos.services.Payment;

import com.example.pos.dtos.request.Payment.TaxReportsRequest;
import com.example.pos.dtos.response.Payment.TaxReportsResponse;
import java.util.List;

/**
 * Service interface for TaxReports.
 * Defines standard CRUD operations for TaxReports, same as Controller methods.
 */
public interface TaxReportsService {

    /**
     * Retrieve all TaxReports records.
     * @return List of TaxReportsResponse
     */
    List<TaxReportsResponse> getAll();

    /**
     * Retrieve a single TaxReports by its ID.
     * @param id ID of the TaxReports
     * @return TaxReportsResponse object
     */
    TaxReportsResponse get(Long id);

    /**
     * Create a new TaxReports record.
     * @param request DTO containing the TaxReports data
     * @return Created TaxReportsResponse
     */
    TaxReportsResponse create(TaxReportsRequest request);

    /**
     * Update an existing TaxReports by its ID.
     * @param id ID of the TaxReports to update
     * @param request DTO containing updated data
     * @return Updated TaxReportsResponse
     */
    TaxReportsResponse update(Long id, TaxReportsRequest request);

    /**
     * Delete a TaxReports by its ID.
     * @param id ID of the TaxReports to delete
     */
    void delete(Long id);
}
