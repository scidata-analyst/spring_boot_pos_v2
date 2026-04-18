package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.StockReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.StockReportsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<StockReportsResponse> index(String search, Pageable pageable);

    StockReportsResponse view(Long id);

    StockReportsResponse create(StockReportsRequest request);

    StockReportsResponse update(Long id, StockReportsRequest request);

    void delete(Long id);
}
