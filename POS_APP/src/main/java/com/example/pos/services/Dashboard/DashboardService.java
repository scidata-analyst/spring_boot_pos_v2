package com.example.pos.services.Dashboard;

import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;

import java.util.List;

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

    List<DashboardResponse> index();

    DashboardResponse view(Long id);

    DashboardResponse create(DashboardRequest request);

    DashboardResponse update(Long id, DashboardRequest request);

    void delete(Long id);
}
