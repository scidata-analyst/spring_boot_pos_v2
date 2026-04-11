package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;

import java.util.List;

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

    List<CashDrawerResponse> index();

    CashDrawerResponse view(Long id);

    CashDrawerResponse create(CashDrawerRequest request);

    CashDrawerResponse update(Long id, CashDrawerRequest request);

    void delete(Long id);
}
