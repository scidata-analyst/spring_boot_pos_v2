package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.PurchaseOrders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseOrdersServiceImpl implements PurchaseOrdersService {

    @Override
    public List<PurchaseOrders> all() {
        return List.of();
    }

    @Override
    public List<PurchaseOrders> index() {
        return List.of();
    }

    @Override
    public Optional<PurchaseOrders> show(Long id) {
        return Optional.empty();
    }

    @Override
    public PurchaseOrders store(PurchaseOrders entity) {
        return entity;
    }

    @Override
    public PurchaseOrders update(Long id, PurchaseOrders entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
