package com.example.pos.services.CustomersCRM;

import com.example.pos.entities.CustomersCRM.LoyaltyPoints;
import com.example.pos.dtos.request.CustomersCRM.LoyaltyPointsRequest;
import com.example.pos.dtos.response.CustomersCRM.LoyaltyPointsResponse;
import com.example.pos.mappers.CustomersCRM.LoyaltyPointsMapper;
import com.example.pos.repositories.CustomersCRM.LoyaltyPointsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for LoyaltyPoints.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class LoyaltyPointsServiceImpl implements LoyaltyPointsService {

    @Autowired
    private LoyaltyPointsRepository repository;

    @Autowired
    private LoyaltyPointsMapper mapper;

    @Override
    public List<LoyaltyPointsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<LoyaltyPointsResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public LoyaltyPointsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public LoyaltyPointsResponse create(LoyaltyPointsRequest request) {
        LoyaltyPoints entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public LoyaltyPointsResponse update(Long id, LoyaltyPointsRequest request) {

        LoyaltyPoints existing = repository.view(id).orElse(null);

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
