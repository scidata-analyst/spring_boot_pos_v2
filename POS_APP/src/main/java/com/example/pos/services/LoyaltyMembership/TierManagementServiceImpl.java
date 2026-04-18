package com.example.pos.services.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.TierManagement;
import com.example.pos.dtos.request.LoyaltyMembership.TierManagementRequest;
import com.example.pos.dtos.response.LoyaltyMembership.TierManagementResponse;
import com.example.pos.mappers.LoyaltyMembership.TierManagementMapper;
import com.example.pos.repositories.LoyaltyMembership.TierManagementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for TierManagement.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class TierManagementServiceImpl implements TierManagementService {

    @Autowired
    private TierManagementRepository repository;

    @Autowired
    private TierManagementMapper mapper;

    @Override
    public List<TierManagementResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<TierManagementResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public TierManagementResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public TierManagementResponse create(TierManagementRequest request) {
        TierManagement entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public TierManagementResponse update(Long id, TierManagementRequest request) {

        TierManagement existing = repository.view(id).orElse(null);

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
