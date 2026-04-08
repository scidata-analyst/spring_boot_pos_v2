package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.APAR;
import java.util.List;
import java.util.Optional;

public interface APARService {
    List<APAR> all();
    List<APAR> index();
    Optional<APAR> show(Long id);
    APAR store(APAR entity);
    APAR update(Long id, APAR entity);
    void destroy(Long id);
}
