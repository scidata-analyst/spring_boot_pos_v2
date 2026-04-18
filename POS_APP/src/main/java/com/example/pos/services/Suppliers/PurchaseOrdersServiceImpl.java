package com.example.pos.services.Suppliers;

import com.example.pos.entities.Suppliers.PurchaseOrders;
import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;
import com.example.pos.mappers.Suppliers.PurchaseOrdersMapper;
import com.example.pos.repositories.Suppliers.PurchaseOrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for PurchaseOrders.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class PurchaseOrdersServiceImpl implements PurchaseOrdersService {

    @Autowired
    private PurchaseOrdersRepository repository;

    @Autowired
    private PurchaseOrdersMapper mapper;

    @Override
    public List<PurchaseOrdersResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<PurchaseOrdersResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public PurchaseOrdersResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public PurchaseOrdersResponse create(PurchaseOrdersRequest request) {
        PurchaseOrders entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public PurchaseOrdersResponse update(Long id, PurchaseOrdersRequest request) {

        PurchaseOrders existing = repository.view(id).orElse(null);

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
