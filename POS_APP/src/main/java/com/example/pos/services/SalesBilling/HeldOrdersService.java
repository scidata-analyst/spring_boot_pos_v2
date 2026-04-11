package com.example.pos.services.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.HeldOrdersRequest;
import com.example.pos.dtos.response.SalesBilling.HeldOrdersResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: HeldOrders
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
public interface HeldOrdersService {

    List<HeldOrdersResponse> all();

    List<HeldOrdersResponse> index();

    HeldOrdersResponse view(Long id);

    HeldOrdersResponse create(HeldOrdersRequest request);

    HeldOrdersResponse update(Long id, HeldOrdersRequest request);

    void delete(Long id);
}
