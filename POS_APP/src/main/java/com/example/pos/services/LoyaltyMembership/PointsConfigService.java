package com.example.pos.services.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: PointsConfig
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all()     -> get all records
 * - index()   -> UI listing (paginated later if needed)
 * - view()    -> single record view
 * - create()  -> create new record
 * - update()  -> update existing record
 * - delete()  -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface PointsConfigService {

    List<PointsConfigResponse> all();

    List<PointsConfigResponse> index();

    PointsConfigResponse view(Long id);

    PointsConfigResponse create(PointsConfigRequest request);

    PointsConfigResponse update(Long id, PointsConfigRequest request);

    void delete(Long id);
}
