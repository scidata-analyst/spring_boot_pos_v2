package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.BatchExpiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchExpiryServiceImpl implements BatchExpiryService {

    @Override
    public List<BatchExpiry> all() {
        return List.of();
    }

    @Override
    public List<BatchExpiry> index() {
        return List.of();
    }

    @Override
    public Optional<BatchExpiry> show(Long id) {
        return Optional.empty();
    }

    @Override
    public BatchExpiry store(BatchExpiry entity) {
        return entity;
    }

    @Override
    public BatchExpiry update(Long id, BatchExpiry entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
