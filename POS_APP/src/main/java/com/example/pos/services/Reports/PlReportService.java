package com.example.pos.services.Reports;

import com.example.pos.dtos.request.Reports.PlReportRequest;
import com.example.pos.dtos.response.Reports.PlReportResponse;
import java.util.List;

/**
 * Service interface for PlReport.
 * Defines standard CRUD operations for PlReport, same as Controller methods.
 */
public interface PlReportService {

    /**
     * Retrieve all PlReport records.
     * @return List of PlReportResponse
     */
    List<PlReportResponse> getAll();

    /**
     * Retrieve a single PlReport by its ID.
     * @param id ID of the PlReport
     * @return PlReportResponse object
     */
    PlReportResponse get(Long id);

    /**
     * Create a new PlReport record.
     * @param request DTO containing the PlReport data
     * @return Created PlReportResponse
     */
    PlReportResponse create(PlReportRequest request);

    /**
     * Update an existing PlReport by its ID.
     * @param id ID of the PlReport to update
     * @param request DTO containing updated data
     * @return Updated PlReportResponse
     */
    PlReportResponse update(Long id, PlReportRequest request);

    /**
     * Delete a PlReport by its ID.
     * @param id ID of the PlReport to delete
     */
    void delete(Long id);
}
