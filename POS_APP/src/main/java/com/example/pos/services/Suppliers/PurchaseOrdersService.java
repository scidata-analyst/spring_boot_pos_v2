package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: PurchaseOrders
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all()     -> get all records
 * - index()   -> UI listing (paginated later if needed)
 * - view()    -> single record view
 * - create()  -> create new record
 * - update()  -> update existing record
 * - delete()  -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface PurchaseOrdersService {

    List<PurchaseOrdersResponse> all();

    List<PurchaseOrdersResponse> index();

    PurchaseOrdersResponse view(Long id);

    PurchaseOrdersResponse create(PurchaseOrdersRequest request);

    PurchaseOrdersResponse update(Long id, PurchaseOrdersRequest request);

    void delete(Long id);
}
