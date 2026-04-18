package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: SupplierPayments
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
public interface SupplierPaymentsService {

    List<SupplierPaymentsResponse> all();

    Page<SupplierPaymentsResponse> index(String search, Pageable pageable);

    SupplierPaymentsResponse view(Long id);

    SupplierPaymentsResponse create(SupplierPaymentsRequest request);

    SupplierPaymentsResponse update(Long id, SupplierPaymentsRequest request);

    void delete(Long id);
}
