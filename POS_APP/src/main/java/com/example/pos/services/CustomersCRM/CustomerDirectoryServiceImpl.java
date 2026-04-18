package com.example.pos.services.CustomersCRM;

import com.example.pos.entities.CustomersCRM.CustomerDirectory;
import com.example.pos.dtos.request.CustomersCRM.CustomerDirectoryRequest;
import com.example.pos.dtos.response.CustomersCRM.CustomerDirectoryResponse;
import com.example.pos.mappers.CustomersCRM.CustomerDirectoryMapper;
import com.example.pos.repositories.CustomersCRM.CustomerDirectoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for CustomerDirectory.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CustomerDirectoryServiceImpl implements CustomerDirectoryService {

    @Autowired
    private CustomerDirectoryRepository repository;

    @Autowired
    private CustomerDirectoryMapper mapper;

    @Override
    public List<CustomerDirectoryResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<CustomerDirectoryResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public CustomerDirectoryResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CustomerDirectoryResponse create(CustomerDirectoryRequest request) {
        CustomerDirectory entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CustomerDirectoryResponse update(Long id, CustomerDirectoryRequest request) {

        CustomerDirectory existing = repository.view(id).orElse(null);

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
