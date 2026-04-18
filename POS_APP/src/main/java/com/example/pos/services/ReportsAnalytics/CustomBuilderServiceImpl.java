package com.example.pos.services.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.CustomBuilder;
import com.example.pos.dtos.request.ReportsAnalytics.CustomBuilderRequest;
import com.example.pos.dtos.response.ReportsAnalytics.CustomBuilderResponse;
import com.example.pos.mappers.ReportsAnalytics.CustomBuilderMapper;
import com.example.pos.repositories.ReportsAnalytics.CustomBuilderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for CustomBuilder.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CustomBuilderServiceImpl implements CustomBuilderService {

    @Autowired
    private CustomBuilderRepository repository;

    @Autowired
    private CustomBuilderMapper mapper;

    @Override
    public List<CustomBuilderResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<CustomBuilderResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public CustomBuilderResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CustomBuilderResponse create(CustomBuilderRequest request) {
        CustomBuilder entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CustomBuilderResponse update(Long id, CustomBuilderRequest request) {

        CustomBuilder existing = repository.view(id).orElse(null);

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
