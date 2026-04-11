package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: BatchExpiry
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
public interface BatchExpiryService {

    List<BatchExpiryResponse> all();

    List<BatchExpiryResponse> index();

    BatchExpiryResponse view(Long id);

    BatchExpiryResponse create(BatchExpiryRequest request);

    BatchExpiryResponse update(Long id, BatchExpiryRequest request);

    void delete(Long id);
}
