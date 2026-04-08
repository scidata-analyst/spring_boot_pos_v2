package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.BarcodeSKU;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarcodeSKUServiceImpl implements BarcodeSKUService {

    @Override
    public List<BarcodeSKU> all() {
        return List.of();
    }

    @Override
    public List<BarcodeSKU> index() {
        return List.of();
    }

    @Override
    public Optional<BarcodeSKU> show(Long id) {
        return Optional.empty();
    }

    @Override
    public BarcodeSKU store(BarcodeSKU entity) {
        return entity;
    }

    @Override
    public BarcodeSKU update(Long id, BarcodeSKU entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
