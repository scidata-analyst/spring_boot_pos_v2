package com.example.pos.services.Suppliers;

import com.example.pos.entities.Suppliers.SupplierPayments;
import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;
import com.example.pos.mappers.Suppliers.SupplierPaymentsMapper;
import com.example.pos.repositories.Suppliers.SupplierPaymentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for SupplierPayments.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class SupplierPaymentsServiceImpl implements SupplierPaymentsService {

    @Autowired
    private SupplierPaymentsRepository repository;

    @Autowired
    private SupplierPaymentsMapper mapper;

    @Override
    public List<SupplierPaymentsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<SupplierPaymentsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public SupplierPaymentsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public SupplierPaymentsResponse create(SupplierPaymentsRequest request) {
        SupplierPayments entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public SupplierPaymentsResponse update(Long id, SupplierPaymentsRequest request) {

        SupplierPayments existing = repository.view(id).orElse(null);

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
