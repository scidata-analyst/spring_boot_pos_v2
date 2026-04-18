package com.example.pos.services.Dashboard;

import com.example.pos.entities.Dashboard.Dashboard;
import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;
import com.example.pos.mappers.Dashboard.DashboardMapper;
import com.example.pos.repositories.Dashboard.DashboardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for Dashboard.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardRepository repository;

    @Autowired
    private DashboardMapper mapper;

    @Override
    public List<DashboardResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<DashboardResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public DashboardResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public DashboardResponse create(DashboardRequest request) {
        Dashboard entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public DashboardResponse update(Long id, DashboardRequest request) {

        Dashboard existing = repository.view(id).orElse(null);

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
