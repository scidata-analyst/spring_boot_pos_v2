package com.example.pos.services.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.LoyaltyPointsRequest;
import com.example.pos.dtos.response.CustomersCRM.LoyaltyPointsResponse;

import java.util.List;

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

    List<LoyaltyPointsResponse> index();

    LoyaltyPointsResponse view(Long id);

    LoyaltyPointsResponse create(LoyaltyPointsRequest request);

    LoyaltyPointsResponse update(Long id, LoyaltyPointsRequest request);

    void delete(Long id);
}
