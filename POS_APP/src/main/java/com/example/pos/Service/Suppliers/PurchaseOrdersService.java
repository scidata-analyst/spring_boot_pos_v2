package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.PurchaseOrders;
import java.util.List;
import java.util.Optional;

public interface PurchaseOrdersService {
    List<PurchaseOrders> all();
    List<PurchaseOrders> index();
    Optional<PurchaseOrders> show(Long id);
    PurchaseOrders store(PurchaseOrders entity);
    PurchaseOrders update(Long id, PurchaseOrders entity);
    void destroy(Long id);
}
