package com.example.pos.services.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.ReturnsRefundsRequest;
import com.example.pos.dtos.response.SalesBilling.ReturnsRefundsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: ReturnsRefunds
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
public interface ReturnsRefundsService {

    List<ReturnsRefundsResponse> all();

    Page<ReturnsRefundsResponse> index(String search, Pageable pageable);

    ReturnsRefundsResponse view(Long id);

    ReturnsRefundsResponse create(ReturnsRefundsRequest request);

    ReturnsRefundsResponse update(Long id, ReturnsRefundsRequest request);

    void delete(Long id);
}
