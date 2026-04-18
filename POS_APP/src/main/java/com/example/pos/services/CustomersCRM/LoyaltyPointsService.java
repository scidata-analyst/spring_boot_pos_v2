package com.example.pos.services.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.LoyaltyPointsRequest;
import com.example.pos.dtos.response.CustomersCRM.LoyaltyPointsResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: LoyaltyPoints
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
public interface LoyaltyPointsService {

    List<LoyaltyPointsResponse> all();

    Page<LoyaltyPointsResponse> index(String search, Pageable pageable);

    LoyaltyPointsResponse view(Long id);

    LoyaltyPointsResponse create(LoyaltyPointsRequest request);

    LoyaltyPointsResponse update(Long id, LoyaltyPointsRequest request);

    void delete(Long id);
}
