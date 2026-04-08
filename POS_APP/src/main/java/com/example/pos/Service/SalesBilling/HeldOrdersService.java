package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.HeldOrders;
import java.util.List;
import java.util.Optional;

public interface HeldOrdersService {
    List<HeldOrders> all();
    List<HeldOrders> index();
    Optional<HeldOrders> show(Long id);
    HeldOrders store(HeldOrders entity);
    HeldOrders update(Long id, HeldOrders entity);
    void destroy(Long id);
}
