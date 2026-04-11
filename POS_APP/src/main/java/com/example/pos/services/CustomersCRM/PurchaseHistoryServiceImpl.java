package com.example.pos.services.CustomersCRM;

import com.example.pos.entities.CustomersCRM.PurchaseHistory;
import com.example.pos.dtos.request.CustomersCRM.PurchaseHistoryRequest;
import com.example.pos.dtos.response.CustomersCRM.PurchaseHistoryResponse;
import com.example.pos.mappers.CustomersCRM.PurchaseHistoryMapper;
import com.example.pos.repositories.CustomersCRM.PurchaseHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for PurchaseHistory.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository repository;

    @Autowired
    private PurchaseHistoryMapper mapper;

    @Override
    public List<PurchaseHistoryResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<PurchaseHistoryResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PurchaseHistoryResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public PurchaseHistoryResponse create(PurchaseHistoryRequest request) {
        PurchaseHistory entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public PurchaseHistoryResponse update(Long id, PurchaseHistoryRequest request) {

        PurchaseHistory existing = repository.view(id).orElse(null);

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
