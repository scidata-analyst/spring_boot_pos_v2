package com.example.pos.services.Dashboard;

import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: Dashboard
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
public interface DashboardService {

    List<DashboardResponse> all();

    Page<DashboardResponse> index(String search, Pageable pageable);

    DashboardResponse view(Long id);

    DashboardResponse create(DashboardRequest request);

    DashboardResponse update(Long id, DashboardRequest request);

    void delete(Long id);
}
