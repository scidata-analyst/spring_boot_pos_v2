package com.example.pos.services.SalesBilling;

import com.example.pos.entities.SalesBilling.Invoices;
import com.example.pos.dtos.request.SalesBilling.InvoicesRequest;
import com.example.pos.dtos.response.SalesBilling.InvoicesResponse;
import com.example.pos.mappers.SalesBilling.InvoicesMapper;
import com.example.pos.repositories.SalesBilling.InvoicesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Invoices.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class InvoicesServiceImpl implements InvoicesService {

    @Autowired
    private InvoicesRepository repository;

    @Autowired
    private InvoicesMapper mapper;

    @Override
    public List<InvoicesResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<InvoicesResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public InvoicesResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public InvoicesResponse create(InvoicesRequest request) {
        Invoices entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public InvoicesResponse update(Long id, InvoicesRequest request) {

        Invoices existing = repository.view(id).orElse(null);

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
