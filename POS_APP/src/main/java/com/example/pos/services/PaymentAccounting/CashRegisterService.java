package com.example.pos.services.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.CashRegisterRequest;
import com.example.pos.dtos.response.PaymentAccounting.CashRegisterResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: CashRegister
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
public interface CashRegisterService {

    List<CashRegisterResponse> all();

    Page<CashRegisterResponse> index(String search, Pageable pageable);

    CashRegisterResponse view(Long id);

    CashRegisterResponse create(CashRegisterRequest request);

    CashRegisterResponse update(Long id, CashRegisterRequest request);

    void delete(Long id);
}
