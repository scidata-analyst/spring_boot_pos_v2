package com.example.pos.Service.Promotions;

import com.example.pos.Entity.Promotions.HappyHour;
import java.util.List;
import java.util.Optional;

public interface HappyHourService {
    List<HappyHour> all();
    List<HappyHour> index();
    Optional<HappyHour> show(Long id);
    HappyHour store(HappyHour entity);
    HappyHour update(Long id, HappyHour entity);
    void destroy(Long id);
}
