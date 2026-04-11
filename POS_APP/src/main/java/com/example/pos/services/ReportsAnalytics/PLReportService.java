package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.PLReportRequest;
import com.example.pos.dtos.response.ReportsAnalytics.PLReportResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: PLReport
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
public interface PLReportService {

    List<PLReportResponse> all();

    List<PLReportResponse> index();

    PLReportResponse view(Long id);

    PLReportResponse create(PLReportRequest request);

    PLReportResponse update(Long id, PLReportRequest request);

    void delete(Long id);
}
