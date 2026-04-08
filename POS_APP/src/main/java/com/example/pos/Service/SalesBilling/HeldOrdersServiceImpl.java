package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.HeldOrders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeldOrdersServiceImpl implements HeldOrdersService {

    @Override
    public List<HeldOrders> all() {
        return List.of();
    }

    @Override
    public List<HeldOrders> index() {
        return List.of();
    }

    @Override
    public Optional<HeldOrders> show(Long id) {
        return Optional.empty();
    }

    @Override
    public HeldOrders store(HeldOrders entity) {
        return entity;
    }

    @Override
    public HeldOrders update(Long id, HeldOrders entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
