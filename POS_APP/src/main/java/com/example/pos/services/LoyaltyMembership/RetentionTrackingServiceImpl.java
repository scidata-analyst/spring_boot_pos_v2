package com.example.pos.services.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.RetentionTracking;
import com.example.pos.dtos.request.LoyaltyMembership.RetentionTrackingRequest;
import com.example.pos.dtos.response.LoyaltyMembership.RetentionTrackingResponse;
import com.example.pos.mappers.LoyaltyMembership.RetentionTrackingMapper;
import com.example.pos.repositories.LoyaltyMembership.RetentionTrackingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for RetentionTracking.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class RetentionTrackingServiceImpl implements RetentionTrackingService {

    @Autowired
    private RetentionTrackingRepository repository;

    @Autowired
    private RetentionTrackingMapper mapper;

    @Override
    public List<RetentionTrackingResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<RetentionTrackingResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public RetentionTrackingResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public RetentionTrackingResponse create(RetentionTrackingRequest request) {
        RetentionTracking entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public RetentionTrackingResponse update(Long id, RetentionTrackingRequest request) {

        RetentionTracking existing = repository.view(id).orElse(null);

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
