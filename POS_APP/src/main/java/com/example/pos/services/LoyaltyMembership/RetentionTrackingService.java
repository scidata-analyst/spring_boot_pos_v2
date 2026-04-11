package com.example.pos.services.LoyaltyMembership;

import com.example.pos.dtos.request.LoyaltyMembership.RetentionTrackingRequest;
import com.example.pos.dtos.response.LoyaltyMembership.RetentionTrackingResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: RetentionTracking
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
public interface RetentionTrackingService {

    List<RetentionTrackingResponse> all();

    List<RetentionTrackingResponse> index();

    RetentionTrackingResponse view(Long id);

    RetentionTrackingResponse create(RetentionTrackingRequest request);

    RetentionTrackingResponse update(Long id, RetentionTrackingRequest request);

    void delete(Long id);
}
