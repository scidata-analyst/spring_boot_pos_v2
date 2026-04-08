package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.PurchaseHistory;
import java.util.List;
import java.util.Optional;

public interface PurchaseHistoryService {
    List<PurchaseHistory> all();
    List<PurchaseHistory> index();
    Optional<PurchaseHistory> show(Long id);
    PurchaseHistory store(PurchaseHistory entity);
    void destroy(Long id);
}
