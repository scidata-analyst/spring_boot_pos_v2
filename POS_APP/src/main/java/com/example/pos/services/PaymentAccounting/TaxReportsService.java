package com.example.pos.services.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.TaxReportsRequest;
import com.example.pos.dtos.response.PaymentAccounting.TaxReportsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: TaxReports
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
public interface TaxReportsService {

    List<TaxReportsResponse> all();

    Page<TaxReportsResponse> index(String search, Pageable pageable);

    TaxReportsResponse view(Long id);

    TaxReportsResponse create(TaxReportsRequest request);

    TaxReportsResponse update(Long id, TaxReportsRequest request);

    void delete(Long id);
}
