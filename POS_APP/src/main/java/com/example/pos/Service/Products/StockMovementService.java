package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.StockMovement;
import java.util.List;
import java.util.Optional;

public interface StockMovementService {
    List<StockMovement> all();
    List<StockMovement> index();
    Optional<StockMovement> show(Long id);
    StockMovement store(StockMovement entity);
    void destroy(Long id);
}
