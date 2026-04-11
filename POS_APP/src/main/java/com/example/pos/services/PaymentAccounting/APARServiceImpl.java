package com.example.pos.services.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.APAR;
import com.example.pos.dtos.request.PaymentAccounting.APARRequest;
import com.example.pos.dtos.response.PaymentAccounting.APARResponse;
import com.example.pos.mappers.PaymentAccounting.APARMapper;
import com.example.pos.repositories.PaymentAccounting.APARRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for APAR.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class APARServiceImpl implements APARService {

    @Autowired
    private APARRepository repository;

    @Autowired
    private APARMapper mapper;

    @Override
    public List<APARResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<APARResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public APARResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public APARResponse create(APARRequest request) {
        APAR entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public APARResponse update(Long id, APARRequest request) {

        APAR existing = repository.view(id).orElse(null);

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
