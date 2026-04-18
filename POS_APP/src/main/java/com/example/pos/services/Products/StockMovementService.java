package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: StockMovement
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
public interface StockMovementService {

    List<StockMovementResponse> all();

    Page<StockMovementResponse> index(String search, Pageable pageable);

    StockMovementResponse view(Long id);

    StockMovementResponse create(StockMovementRequest request);

    StockMovementResponse update(Long id, StockMovementRequest request);

    void delete(Long id);
}
