package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.Reconciliation;
import java.util.List;
import java.util.Optional;

public interface ReconciliationService {
    List<Reconciliation> all();
    List<Reconciliation> index();
    Optional<Reconciliation> show(Long id);
    Reconciliation store(Reconciliation entity);
    Reconciliation update(Long id, Reconciliation entity);
    void destroy(Long id);
}
