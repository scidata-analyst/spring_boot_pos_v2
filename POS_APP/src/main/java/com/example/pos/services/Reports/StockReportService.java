package com.example.pos.services.Reports;

import com.example.pos.dtos.request.Reports.StockReportRequest;
import com.example.pos.dtos.response.Reports.StockReportResponse;
import java.util.List;

/**
 * Service interface for StockReport.
 * Defines standard CRUD operations for StockReport, same as Controller methods.
 */
public interface StockReportService {

    /**
     * Retrieve all StockReport records.
     * @return List of StockReportResponse
     */
    List<StockReportResponse> getAll();

    /**
     * Retrieve a single StockReport by its ID.
     * @param id ID of the StockReport
     * @return StockReportResponse object
     */
    StockReportResponse get(Long id);

    /**
     * Create a new StockReport record.
     * @param request DTO containing the StockReport data
     * @return Created StockReportResponse
     */
    StockReportResponse create(StockReportRequest request);

    /**
     * Update an existing StockReport by its ID.
     * @param id ID of the StockReport to update
     * @param request DTO containing updated data
     * @return Updated StockReportResponse
     */
    StockReportResponse update(Long id, StockReportRequest request);

    /**
     * Delete a StockReport by its ID.
     * @param id ID of the StockReport to delete
     */
    void delete(Long id);
}
