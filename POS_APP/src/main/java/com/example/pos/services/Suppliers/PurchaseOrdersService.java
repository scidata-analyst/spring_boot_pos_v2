package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: PurchaseOrders
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
public interface PurchaseOrdersService {

    List<PurchaseOrdersResponse> all();

    Page<PurchaseOrdersResponse> index(String search, Pageable pageable);

    PurchaseOrdersResponse view(Long id);

    PurchaseOrdersResponse create(PurchaseOrdersRequest request);

    PurchaseOrdersResponse update(Long id, PurchaseOrdersRequest request);

    void delete(Long id);
}
