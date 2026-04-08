package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.APAR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class APARServiceImpl implements APARService {

    @Override
    public List<APAR> all() {
        return List.of();
    }

    @Override
    public List<APAR> index() {
        return List.of();
    }

    @Override
    public Optional<APAR> show(Long id) {
        return Optional.empty();
    }

    @Override
    public APAR store(APAR entity) {
        return entity;
    }

    @Override
    public APAR update(Long id, APAR entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
