package com.example.pos.services.Reports;

import com.example.pos.dtos.request.Reports.SalesReportRequest;
import com.example.pos.dtos.response.Reports.SalesReportResponse;
import java.util.List;

/**
 * Service interface for SalesReport.
 * Defines standard CRUD operations for SalesReport, same as Controller methods.
 */
public interface SalesReportService {

    /**
     * Retrieve all SalesReport records.
     * @return List of SalesReportResponse
     */
    List<SalesReportResponse> getAll();

    /**
     * Retrieve a single SalesReport by its ID.
     * @param id ID of the SalesReport
     * @return SalesReportResponse object
     */
    SalesReportResponse get(Long id);

    /**
     * Create a new SalesReport record.
     * @param request DTO containing the SalesReport data
     * @return Created SalesReportResponse
     */
    SalesReportResponse create(SalesReportRequest request);

    /**
     * Update an existing SalesReport by its ID.
     * @param id ID of the SalesReport to update
     * @param request DTO containing updated data
     * @return Updated SalesReportResponse
     */
    SalesReportResponse update(Long id, SalesReportRequest request);

    /**
     * Delete a SalesReport by its ID.
     * @param id ID of the SalesReport to delete
     */
    void delete(Long id);
}
