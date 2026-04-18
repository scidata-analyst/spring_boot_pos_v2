package com.example.pos.services.SalesBilling;

import com.example.pos.entities.SalesBilling.HeldOrders;
import com.example.pos.dtos.request.SalesBilling.HeldOrdersRequest;
import com.example.pos.dtos.response.SalesBilling.HeldOrdersResponse;
import com.example.pos.mappers.SalesBilling.HeldOrdersMapper;
import com.example.pos.repositories.SalesBilling.HeldOrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for HeldOrders.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class HeldOrdersServiceImpl implements HeldOrdersService {

    @Autowired
    private HeldOrdersRepository repository;

    @Autowired
    private HeldOrdersMapper mapper;

    @Override
    public List<HeldOrdersResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<HeldOrdersResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public HeldOrdersResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public HeldOrdersResponse create(HeldOrdersRequest request) {
        HeldOrders entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public HeldOrdersResponse update(Long id, HeldOrdersRequest request) {

        HeldOrders existing = repository.view(id).orElse(null);

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
