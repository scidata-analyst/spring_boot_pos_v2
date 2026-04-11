package com.example.pos.services.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.PLReport;
import com.example.pos.dtos.request.ReportsAnalytics.PLReportRequest;
import com.example.pos.dtos.response.ReportsAnalytics.PLReportResponse;
import com.example.pos.mappers.ReportsAnalytics.PLReportMapper;
import com.example.pos.repositories.ReportsAnalytics.PLReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for PLReport.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class PLReportServiceImpl implements PLReportService {

    @Autowired
    private PLReportRepository repository;

    @Autowired
    private PLReportMapper mapper;

    @Override
    public List<PLReportResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<PLReportResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PLReportResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public PLReportResponse create(PLReportRequest request) {
        PLReport entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public PLReportResponse update(Long id, PLReportRequest request) {

        PLReport existing = repository.view(id).orElse(null);

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
