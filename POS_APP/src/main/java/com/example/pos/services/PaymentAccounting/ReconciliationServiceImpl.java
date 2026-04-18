package com.example.pos.services.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.Reconciliation;
import com.example.pos.dtos.request.PaymentAccounting.ReconciliationRequest;
import com.example.pos.dtos.response.PaymentAccounting.ReconciliationResponse;
import com.example.pos.mappers.PaymentAccounting.ReconciliationMapper;
import com.example.pos.repositories.PaymentAccounting.ReconciliationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for Reconciliation.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class ReconciliationServiceImpl implements ReconciliationService {

    @Autowired
    private ReconciliationRepository repository;

    @Autowired
    private ReconciliationMapper mapper;

    @Override
    public List<ReconciliationResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<ReconciliationResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public ReconciliationResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public ReconciliationResponse create(ReconciliationRequest request) {
        Reconciliation entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public ReconciliationResponse update(Long id, ReconciliationRequest request) {

        Reconciliation existing = repository.view(id).orElse(null);

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
