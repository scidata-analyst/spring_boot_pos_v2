package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.ProductCatalog;
import java.util.List;
import java.util.Optional;

public interface ProductCatalogService {
    List<ProductCatalog> all();
    List<ProductCatalog> index();
    Optional<ProductCatalog> show(Long id);
    ProductCatalog store(ProductCatalog entity);
    ProductCatalog update(Long id, ProductCatalog entity);
    void destroy(Long id);
}
