package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.StockReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.StockReportsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: StockReports
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated later if needed)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface StockReportsService {

    List<StockReportsResponse> all();

    List<StockReportsResponse> index();

    StockReportsResponse view(Long id);

    StockReportsResponse create(StockReportsRequest request);

    StockReportsResponse update(Long id, StockReportsRequest request);

    void delete(Long id);
}
