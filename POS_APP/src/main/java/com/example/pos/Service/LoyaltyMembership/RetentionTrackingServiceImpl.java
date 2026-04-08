package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.RetentionTracking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetentionTrackingServiceImpl implements RetentionTrackingService {

    @Override
    public List<RetentionTracking> all() {
        return List.of();
    }

    @Override
    public List<RetentionTracking> index() {
        return List.of();
    }

    @Override
    public Optional<RetentionTracking> show(Long id) {
        return Optional.empty();
    }

    @Override
    public RetentionTracking store(RetentionTracking entity) {
        return entity;
    }

    @Override
    public RetentionTracking update(Long id, RetentionTracking entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
