package com.example.pos.Repository.Products;

import com.example.pos.Entity.Products.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
}
