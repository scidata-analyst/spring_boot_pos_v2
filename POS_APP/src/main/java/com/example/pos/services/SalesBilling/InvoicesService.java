package com.example.pos.services.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.InvoicesRequest;
import com.example.pos.dtos.response.SalesBilling.InvoicesResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: Invoices
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
public interface InvoicesService {

    List<InvoicesResponse> all();

    List<InvoicesResponse> index();

    InvoicesResponse view(Long id);

    InvoicesResponse create(InvoicesRequest request);

    InvoicesResponse update(Long id, InvoicesRequest request);

    void delete(Long id);
}
