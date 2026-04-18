package com.example.pos.services.Products;

import com.example.pos.entities.Products.BarcodeSKU;
import com.example.pos.dtos.request.Products.BarcodeSKURequest;
import com.example.pos.dtos.response.Products.BarcodeSKUResponse;
import com.example.pos.mappers.Products.BarcodeSKUMapper;
import com.example.pos.repositories.Products.BarcodeSKURepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for BarcodeSKU.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class BarcodeSKUServiceImpl implements BarcodeSKUService {

    @Autowired
    private BarcodeSKURepository repository;

    @Autowired
    private BarcodeSKUMapper mapper;

    @Override
    public List<BarcodeSKUResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<BarcodeSKUResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public BarcodeSKUResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public BarcodeSKUResponse create(BarcodeSKURequest request) {
        BarcodeSKU entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public BarcodeSKUResponse update(Long id, BarcodeSKURequest request) {

        BarcodeSKU existing = repository.view(id).orElse(null);

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
