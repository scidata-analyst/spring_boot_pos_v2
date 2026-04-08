package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.ProductCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Override
    public List<ProductCatalog> all() {
        return List.of();
    }

    @Override
    public List<ProductCatalog> index() {
        return List.of();
    }

    @Override
    public Optional<ProductCatalog> show(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductCatalog store(ProductCatalog entity) {
        return entity;
    }

    @Override
    public ProductCatalog update(Long id, ProductCatalog entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
