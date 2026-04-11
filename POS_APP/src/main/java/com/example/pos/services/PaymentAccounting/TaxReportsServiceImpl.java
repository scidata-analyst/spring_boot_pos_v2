package com.example.pos.services.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.TaxReports;
import com.example.pos.dtos.request.PaymentAccounting.TaxReportsRequest;
import com.example.pos.dtos.response.PaymentAccounting.TaxReportsResponse;
import com.example.pos.mappers.PaymentAccounting.TaxReportsMapper;
import com.example.pos.repositories.PaymentAccounting.TaxReportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for TaxReports.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class TaxReportsServiceImpl implements TaxReportsService {

    @Autowired
    private TaxReportsRepository repository;

    @Autowired
    private TaxReportsMapper mapper;

    @Override
    public List<TaxReportsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<TaxReportsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public TaxReportsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public TaxReportsResponse create(TaxReportsRequest request) {
        TaxReports entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public TaxReportsResponse update(Long id, TaxReportsRequest request) {

        TaxReports existing = repository.view(id).orElse(null);

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
