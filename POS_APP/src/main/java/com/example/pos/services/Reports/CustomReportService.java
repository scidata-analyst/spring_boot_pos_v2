package com.example.pos.services.Reports;

import com.example.pos.dtos.request.Reports.CustomReportRequest;
import com.example.pos.dtos.response.Reports.CustomReportResponse;
import java.util.List;

/**
 * Service interface for CustomReport.
 * Defines standard CRUD operations for CustomReport, same as Controller methods.
 */
public interface CustomReportService {

    /**
     * Retrieve all CustomReport records.
     * @return List of CustomReportResponse
     */
    List<CustomReportResponse> getAll();

    /**
     * Retrieve a single CustomReport by its ID.
     * @param id ID of the CustomReport
     * @return CustomReportResponse object
     */
    CustomReportResponse get(Long id);

    /**
     * Create a new CustomReport record.
     * @param request DTO containing the CustomReport data
     * @return Created CustomReportResponse
     */
    CustomReportResponse create(CustomReportRequest request);

    /**
     * Update an existing CustomReport by its ID.
     * @param id ID of the CustomReport to update
     * @param request DTO containing updated data
     * @return Updated CustomReportResponse
     */
    CustomReportResponse update(Long id, CustomReportRequest request);

    /**
     * Delete a CustomReport by its ID.
     * @param id ID of the CustomReport to delete
     */
    void delete(Long id);
}
