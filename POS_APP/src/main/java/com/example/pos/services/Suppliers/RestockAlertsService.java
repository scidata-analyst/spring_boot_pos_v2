package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: RestockAlerts
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
public interface RestockAlertsService {

    List<RestockAlertsResponse> all();

    List<RestockAlertsResponse> index();

    RestockAlertsResponse view(Long id);

    RestockAlertsResponse create(RestockAlertsRequest request);

    RestockAlertsResponse update(Long id, RestockAlertsRequest request);

    void delete(Long id);
}
