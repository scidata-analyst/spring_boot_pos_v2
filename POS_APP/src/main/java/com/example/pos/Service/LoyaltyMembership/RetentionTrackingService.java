package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.RetentionTracking;
import java.util.List;
import java.util.Optional;

public interface RetentionTrackingService {
    List<RetentionTracking> all();
    List<RetentionTracking> index();
    Optional<RetentionTracking> show(Long id);
    RetentionTracking store(RetentionTracking entity);
    RetentionTracking update(Long id, RetentionTracking entity);
    void destroy(Long id);
}
