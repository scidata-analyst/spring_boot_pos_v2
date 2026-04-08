package com.example.pos.Service.LoyaltyMembership;

import com.example.pos.Entity.LoyaltyMembership.PointsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointsConfigServiceImpl implements PointsConfigService {

    @Override
    public List<PointsConfig> all() {
        return List.of();
    }

    @Override
    public List<PointsConfig> index() {
        return List.of();
    }

    @Override
    public Optional<PointsConfig> show(Long id) {
        return Optional.empty();
    }

    @Override
    public PointsConfig store(PointsConfig entity) {
        return entity;
    }

    @Override
    public PointsConfig update(Long id, PointsConfig entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
