package com.example.pos.services.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: PointsConfig
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
public interface PointsConfigService {

    List<PointsConfigResponse> all();

    Page<PointsConfigResponse> index(String search, Pageable pageable);

    PointsConfigResponse view(Long id);

    PointsConfigResponse create(PointsConfigRequest request);

    PointsConfigResponse update(Long id, PointsConfigRequest request);

    void delete(Long id);
}
