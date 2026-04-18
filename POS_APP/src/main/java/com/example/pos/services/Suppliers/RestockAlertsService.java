package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<RestockAlertsResponse> index(String search, Pageable pageable);

    RestockAlertsResponse view(Long id);

    RestockAlertsResponse create(RestockAlertsRequest request);

    RestockAlertsResponse update(Long id, RestockAlertsRequest request);

    void delete(Long id);
}
