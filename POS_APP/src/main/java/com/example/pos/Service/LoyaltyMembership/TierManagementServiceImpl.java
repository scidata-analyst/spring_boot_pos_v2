package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.TierManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TierManagementServiceImpl implements TierManagementService {

    @Override
    public List<TierManagement> all() {
        return List.of();
    }

    @Override
    public List<TierManagement> index() {
        return List.of();
    }

    @Override
    public Optional<TierManagement> show(Long id) {
        return Optional.empty();
    }

    @Override
    public TierManagement store(TierManagement entity) {
        return entity;
    }

    @Override
    public TierManagement update(Long id, TierManagement entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
