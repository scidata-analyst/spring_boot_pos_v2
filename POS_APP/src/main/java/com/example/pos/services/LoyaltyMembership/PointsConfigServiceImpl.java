package com.example.pos.services.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.PointsConfig;
import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;
import com.example.pos.mappers.LoyaltyMembership.PointsConfigMapper;
import com.example.pos.repositories.LoyaltyMembership.PointsConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for PointsConfig.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class PointsConfigServiceImpl implements PointsConfigService {

    @Autowired
    private PointsConfigRepository repository;

    @Autowired
    private PointsConfigMapper mapper;

    @Override
    public List<PointsConfigResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<PointsConfigResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PointsConfigResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public PointsConfigResponse create(PointsConfigRequest request) {
        PointsConfig entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public PointsConfigResponse update(Long id, PointsConfigRequest request) {

        PointsConfig existing = repository.view(id).orElse(null);

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
