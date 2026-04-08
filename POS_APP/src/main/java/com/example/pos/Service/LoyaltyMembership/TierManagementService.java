package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.TierManagement;
import java.util.List;
import java.util.Optional;

public interface TierManagementService {
    List<TierManagement> all();
    List<TierManagement> index();
    Optional<TierManagement> show(Long id);
    TierManagement store(TierManagement entity);
    TierManagement update(Long id, TierManagement entity);
    void destroy(Long id);
}
