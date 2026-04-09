package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;
import java.util.List;

/**
 * Service interface for RestockAlerts.
 * Defines standard CRUD operations for RestockAlerts, same as Controller methods.
 */
public interface RestockAlertsService {

    /**
     * Retrieve all RestockAlerts records.
     * @return List of RestockAlertsResponse
     */
    List<RestockAlertsResponse> getAll();

    /**
     * Retrieve a single RestockAlerts by its ID.
     * @param id ID of the RestockAlerts
     * @return RestockAlertsResponse object
     */
    RestockAlertsResponse get(Long id);

    /**
     * Create a new RestockAlerts record.
     * @param request DTO containing the RestockAlerts data
     * @return Created RestockAlertsResponse
     */
    RestockAlertsResponse create(RestockAlertsRequest request);

    /**
     * Update an existing RestockAlerts by its ID.
     * @param id ID of the RestockAlerts to update
     * @param request DTO containing updated data
     * @return Updated RestockAlertsResponse
     */
    RestockAlertsResponse update(Long id, RestockAlertsRequest request);

    /**
     * Delete a RestockAlerts by its ID.
     * @param id ID of the RestockAlerts to delete
     */
    void delete(Long id);
}
