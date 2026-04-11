package com.example.pos.services.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.StockReports;
import com.example.pos.dtos.request.ReportsAnalytics.StockReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.StockReportsResponse;
import com.example.pos.mappers.ReportsAnalytics.StockReportsMapper;
import com.example.pos.repositories.ReportsAnalytics.StockReportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for StockReports.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class StockReportsServiceImpl implements StockReportsService {

    @Autowired
    private StockReportsRepository repository;

    @Autowired
    private StockReportsMapper mapper;

    @Override
    public List<StockReportsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<StockReportsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StockReportsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public StockReportsResponse create(StockReportsRequest request) {
        StockReports entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public StockReportsResponse update(Long id, StockReportsRequest request) {

        StockReports existing = repository.view(id).orElse(null);

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
