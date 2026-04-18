package com.example.pos.services.Products;

import com.example.pos.entities.Products.ProductCatalog;
import com.example.pos.dtos.request.Products.ProductCatalogRequest;
import com.example.pos.dtos.response.Products.ProductCatalogResponse;
import com.example.pos.mappers.Products.ProductCatalogMapper;
import com.example.pos.repositories.Products.ProductCatalogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for ProductCatalog.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    private ProductCatalogRepository repository;

    @Autowired
    private ProductCatalogMapper mapper;

    @Override
    public List<ProductCatalogResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<ProductCatalogResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public ProductCatalogResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public ProductCatalogResponse create(ProductCatalogRequest request) {
        ProductCatalog entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public ProductCatalogResponse update(Long id, ProductCatalogRequest request) {

        ProductCatalog existing = repository.view(id).orElse(null);

        if (existing == null)
            return null;

        mapper.updateEntity(request, existing);

        return mapper.toResponse(repository.update(existing));
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
