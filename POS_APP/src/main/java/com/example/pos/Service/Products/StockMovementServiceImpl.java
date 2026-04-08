package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.StockMovement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    @Override
    public List<StockMovement> all() {
        return List.of();
    }

    @Override
    public List<StockMovement> index() {
        return List.of();
    }

    @Override
    public Optional<StockMovement> show(Long id) {
        return Optional.empty();
    }

    @Override
    public StockMovement store(StockMovement entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
