package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.SalesReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.SalesReportsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: SalesReports
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
public interface SalesReportsService {

    List<SalesReportsResponse> all();

    List<SalesReportsResponse> index();

    SalesReportsResponse view(Long id);

    SalesReportsResponse create(SalesReportsRequest request);

    SalesReportsResponse update(Long id, SalesReportsRequest request);

    void delete(Long id);
}
