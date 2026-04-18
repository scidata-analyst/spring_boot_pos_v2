package com.example.pos.services.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.TierManagementRequest;
import com.example.pos.dtos.response.LoyaltyMembership.TierManagementResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: TierManagement
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
public interface TierManagementService {

    List<TierManagementResponse> all();

    Page<TierManagementResponse> index(String search, Pageable pageable);

    TierManagementResponse view(Long id);

    TierManagementResponse create(TierManagementRequest request);

    TierManagementResponse update(Long id, TierManagementRequest request);

    void delete(Long id);
}
