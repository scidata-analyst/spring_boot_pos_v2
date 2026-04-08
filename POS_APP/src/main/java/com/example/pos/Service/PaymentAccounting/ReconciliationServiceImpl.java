package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.Reconciliation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReconciliationServiceImpl implements ReconciliationService {

    @Override
    public List<Reconciliation> all() {
        return List.of();
    }

    @Override
    public List<Reconciliation> index() {
        return List.of();
    }

    @Override
    public Optional<Reconciliation> show(Long id) {
        return Optional.empty();
    }

    @Override
    public Reconciliation store(Reconciliation entity) {
        return entity;
    }

    @Override
    public Reconciliation update(Long id, Reconciliation entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
