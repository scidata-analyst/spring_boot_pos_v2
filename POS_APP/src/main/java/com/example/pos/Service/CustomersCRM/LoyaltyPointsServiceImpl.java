package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.LoyaltyPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoyaltyPointsServiceImpl implements LoyaltyPointsService {

    @Override
    public List<LoyaltyPoints> all() {
        return List.of();
    }

    @Override
    public List<LoyaltyPoints> index() {
        return List.of();
    }

    @Override
    public Optional<LoyaltyPoints> show(Long id) {
        return Optional.empty();
    }

    @Override
    public LoyaltyPoints store(LoyaltyPoints entity) {
        return entity;
    }

    @Override
    public LoyaltyPoints update(Long id, LoyaltyPoints entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
