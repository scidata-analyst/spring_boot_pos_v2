package com.example.pos.services.Products;

import com.example.pos.entities.Products.StockMovement;
import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;
import com.example.pos.mappers.Products.StockMovementMapper;
import com.example.pos.repositories.Products.StockMovementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for StockMovement.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class StockMovementServiceImpl implements StockMovementService {

    @Autowired
    private StockMovementRepository repository;

    @Autowired
    private StockMovementMapper mapper;

    @Override
    public List<StockMovementResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<StockMovementResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public StockMovementResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public StockMovementResponse create(StockMovementRequest request) {
        StockMovement entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public StockMovementResponse update(Long id, StockMovementRequest request) {

        StockMovement existing = repository.view(id).orElse(null);

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
