package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: CashDrawer
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
public interface CashDrawerService {

    List<CashDrawerResponse> all();

    Page<CashDrawerResponse> index(String search, Pageable pageable);

    CashDrawerResponse view(Long id);

    CashDrawerResponse create(CashDrawerRequest request);

    CashDrawerResponse update(Long id, CashDrawerRequest request);

    void delete(Long id);
}
