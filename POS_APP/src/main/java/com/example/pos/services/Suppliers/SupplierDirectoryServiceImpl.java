package com.example.pos.services.Suppliers;

import com.example.pos.entities.Suppliers.SupplierDirectory;
import com.example.pos.dtos.request.Suppliers.SupplierDirectoryRequest;
import com.example.pos.dtos.response.Suppliers.SupplierDirectoryResponse;
import com.example.pos.mappers.Suppliers.SupplierDirectoryMapper;
import com.example.pos.repositories.Suppliers.SupplierDirectoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for SupplierDirectory.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class SupplierDirectoryServiceImpl implements SupplierDirectoryService {

    @Autowired
    private SupplierDirectoryRepository repository;

    @Autowired
    private SupplierDirectoryMapper mapper;

    @Override
    public List<SupplierDirectoryResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<SupplierDirectoryResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public SupplierDirectoryResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public SupplierDirectoryResponse create(SupplierDirectoryRequest request) {
        SupplierDirectory entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public SupplierDirectoryResponse update(Long id, SupplierDirectoryRequest request) {

        SupplierDirectory existing = repository.view(id).orElse(null);

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
