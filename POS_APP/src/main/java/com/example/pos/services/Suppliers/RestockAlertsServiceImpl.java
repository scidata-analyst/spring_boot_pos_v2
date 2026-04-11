package com.example.pos.services.Suppliers;

import com.example.pos.entities.Suppliers.RestockAlerts;
import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;
import com.example.pos.mappers.Suppliers.RestockAlertsMapper;
import com.example.pos.repositories.Suppliers.RestockAlertsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for RestockAlerts.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class RestockAlertsServiceImpl implements RestockAlertsService {

    @Autowired
    private RestockAlertsRepository repository;

    @Autowired
    private RestockAlertsMapper mapper;

    @Override
    public List<RestockAlertsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<RestockAlertsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public RestockAlertsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public RestockAlertsResponse create(RestockAlertsRequest request) {
        RestockAlerts entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public RestockAlertsResponse update(Long id, RestockAlertsRequest request) {

        RestockAlerts existing = repository.view(id).orElse(null);

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
