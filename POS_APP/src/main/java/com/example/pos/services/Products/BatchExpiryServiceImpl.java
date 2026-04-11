package com.example.pos.services.Products;

import com.example.pos.entities.Products.BatchExpiry;
import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;
import com.example.pos.mappers.Products.BatchExpiryMapper;
import com.example.pos.repositories.Products.BatchExpiryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for BatchExpiry.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class BatchExpiryServiceImpl implements BatchExpiryService {

    @Autowired
    private BatchExpiryRepository repository;

    @Autowired
    private BatchExpiryMapper mapper;

    @Override
    public List<BatchExpiryResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<BatchExpiryResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public BatchExpiryResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public BatchExpiryResponse create(BatchExpiryRequest request) {
        BatchExpiry entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public BatchExpiryResponse update(Long id, BatchExpiryRequest request) {

        BatchExpiry existing = repository.view(id).orElse(null);

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
