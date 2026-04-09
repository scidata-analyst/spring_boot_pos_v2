package com.example.pos.services.Core;

import com.example.pos.dtos.request.Core.DashboardRequest;
import com.example.pos.dtos.response.Core.DashboardResponse;
import java.util.List;

/**
 * Service interface for Dashboard.
 * Defines standard CRUD operations for Dashboard, same as Controller methods.
 */
public interface DashboardService {

    /**
     * Retrieve all Dashboard records.
     * @return List of DashboardResponse
     */
    List<DashboardResponse> getAll();

    /**
     * Retrieve a single Dashboard by its ID.
     * @param id ID of the Dashboard
     * @return DashboardResponse object
     */
    DashboardResponse get(Long id);

    /**
     * Create a new Dashboard record.
     * @param request DTO containing the Dashboard data
     * @return Created DashboardResponse
     */
    DashboardResponse create(DashboardRequest request);

    /**
     * Update an existing Dashboard by its ID.
     * @param id ID of the Dashboard to update
     * @param request DTO containing updated data
     * @return Updated DashboardResponse
     */
    DashboardResponse update(Long id, DashboardRequest request);

    /**
     * Delete a Dashboard by its ID.
     * @param id ID of the Dashboard to delete
     */
    void delete(Long id);
}
