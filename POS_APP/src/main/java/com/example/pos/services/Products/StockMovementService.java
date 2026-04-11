package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: StockMovement
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
public interface StockMovementService {

    List<StockMovementResponse> all();

    List<StockMovementResponse> index();

    StockMovementResponse view(Long id);

    StockMovementResponse create(StockMovementRequest request);

    StockMovementResponse update(Long id, StockMovementRequest request);

    void delete(Long id);
}
