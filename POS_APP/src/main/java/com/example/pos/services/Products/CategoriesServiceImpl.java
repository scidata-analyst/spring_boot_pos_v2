package com.example.pos.services.Products;

import com.example.pos.entities.Products.Categories;
import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;
import com.example.pos.mappers.Products.CategoriesMapper;
import com.example.pos.repositories.Products.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for Categories.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository repository;

    @Autowired
    private CategoriesMapper mapper;

    @Override
    public List<CategoriesResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<CategoriesResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public CategoriesResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CategoriesResponse create(CategoriesRequest request) {
        Categories entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CategoriesResponse update(Long id, CategoriesRequest request) {

        Categories existing = repository.view(id).orElse(null);

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
