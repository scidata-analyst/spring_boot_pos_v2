package com.example.pos.services.Promotions;

import com.example.pos.dtos.request.Promotions.CouponCodesRequest;
import com.example.pos.dtos.response.Promotions.CouponCodesResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: CouponCodes
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
public interface CouponCodesService {

    List<CouponCodesResponse> all();

    Page<CouponCodesResponse> index(String search, Pageable pageable);

    CouponCodesResponse view(Long id);

    CouponCodesResponse create(CouponCodesRequest request);

    CouponCodesResponse update(Long id, CouponCodesRequest request);

    void delete(Long id);
}
