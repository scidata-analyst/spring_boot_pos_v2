package com.example.pos.services.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.ReconciliationRequest;
import com.example.pos.dtos.response.PaymentAccounting.ReconciliationResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: Reconciliation
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
public interface ReconciliationService {

    List<ReconciliationResponse> all();

    List<ReconciliationResponse> index();

    ReconciliationResponse view(Long id);

    ReconciliationResponse create(ReconciliationRequest request);

    ReconciliationResponse update(Long id, ReconciliationRequest request);

    void delete(Long id);
}
