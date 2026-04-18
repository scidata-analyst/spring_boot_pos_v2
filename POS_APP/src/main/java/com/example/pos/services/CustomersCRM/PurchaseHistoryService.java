package com.example.pos.services.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.PurchaseHistoryRequest;
import com.example.pos.dtos.response.CustomersCRM.PurchaseHistoryResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: PurchaseHistory
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
public interface PurchaseHistoryService {

    List<PurchaseHistoryResponse> all();

    Page<PurchaseHistoryResponse> index(String search, Pageable pageable);

    PurchaseHistoryResponse view(Long id);

    PurchaseHistoryResponse create(PurchaseHistoryRequest request);

    PurchaseHistoryResponse update(Long id, PurchaseHistoryRequest request);

    void delete(Long id);
}
