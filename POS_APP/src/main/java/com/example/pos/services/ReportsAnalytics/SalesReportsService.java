package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.SalesReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.SalesReportsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<SalesReportsResponse> index(String search, Pageable pageable);

    SalesReportsResponse view(Long id);

    SalesReportsResponse create(SalesReportsRequest request);

    SalesReportsResponse update(Long id, SalesReportsRequest request);

    void delete(Long id);
}
