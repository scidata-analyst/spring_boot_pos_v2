package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.PointsConfig;
import java.util.List;
import java.util.Optional;

public interface PointsConfigService {
    List<PointsConfig> all();
    List<PointsConfig> index();
    Optional<PointsConfig> show(Long id);
    PointsConfig store(PointsConfig entity);
    PointsConfig update(Long id, PointsConfig entity);
    void destroy(Long id);
}
