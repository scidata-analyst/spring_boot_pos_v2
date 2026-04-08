package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.LoyaltyPoints;
import java.util.List;
import java.util.Optional;

public interface LoyaltyPointsService {
    List<LoyaltyPoints> all();
    List<LoyaltyPoints> index();
    Optional<LoyaltyPoints> show(Long id);
    LoyaltyPoints store(LoyaltyPoints entity);
    LoyaltyPoints update(Long id, LoyaltyPoints entity);
    void destroy(Long id);
}
