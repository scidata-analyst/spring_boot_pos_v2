package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.ProductCatalogRequest;
import com.example.pos.dtos.response.Products.ProductCatalogResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: ProductCatalog
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated later if needed)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface ProductCatalogService {

    List<ProductCatalogResponse> all();

    Page<ProductCatalogResponse> index(String search, Pageable pageable);

    ProductCatalogResponse view(Long id);

    ProductCatalogResponse create(ProductCatalogRequest request);

    ProductCatalogResponse update(Long id, ProductCatalogRequest request);

    void delete(Long id);
}
