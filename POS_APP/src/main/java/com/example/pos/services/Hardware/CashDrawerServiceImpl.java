package com.example.pos.services.Hardware;

import com.example.pos.entities.Hardware.CashDrawer;
import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;
import com.example.pos.mappers.Hardware.CashDrawerMapper;
import com.example.pos.repositories.Hardware.CashDrawerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for CashDrawer.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CashDrawerServiceImpl implements CashDrawerService {

    @Autowired
    private CashDrawerRepository repository;

    @Autowired
    private CashDrawerMapper mapper;

    @Override
    public List<CashDrawerResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<CashDrawerResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CashDrawerResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CashDrawerResponse create(CashDrawerRequest request) {
        CashDrawer entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CashDrawerResponse update(Long id, CashDrawerRequest request) {

        CashDrawer existing = repository.view(id).orElse(null);

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
