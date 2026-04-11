package com.example.pos.services.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.TransactionsRequest;
import com.example.pos.dtos.response.SalesBilling.TransactionsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: Transactions
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
public interface TransactionsService {

    List<TransactionsResponse> all();

    List<TransactionsResponse> index();

    TransactionsResponse view(Long id);

    TransactionsResponse create(TransactionsRequest request);

    TransactionsResponse update(Long id, TransactionsRequest request);

    void delete(Long id);
}
