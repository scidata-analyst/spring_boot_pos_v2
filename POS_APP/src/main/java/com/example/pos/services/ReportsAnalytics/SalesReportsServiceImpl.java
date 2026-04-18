package com.example.pos.services.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.SalesReports;
import com.example.pos.dtos.request.ReportsAnalytics.SalesReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.SalesReportsResponse;
import com.example.pos.mappers.ReportsAnalytics.SalesReportsMapper;
import com.example.pos.repositories.ReportsAnalytics.SalesReportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for SalesReports.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class SalesReportsServiceImpl implements SalesReportsService {

    @Autowired
    private SalesReportsRepository repository;

    @Autowired
    private SalesReportsMapper mapper;

    @Override
    public List<SalesReportsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<SalesReportsResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public SalesReportsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public SalesReportsResponse create(SalesReportsRequest request) {
        SalesReports entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public SalesReportsResponse update(Long id, SalesReportsRequest request) {

        SalesReports existing = repository.view(id).orElse(null);

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
