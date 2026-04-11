package com.example.pos.services.SalesBilling;

import com.example.pos.entities.SalesBilling.Transactions;
import com.example.pos.dtos.request.SalesBilling.TransactionsRequest;
import com.example.pos.dtos.response.SalesBilling.TransactionsResponse;
import com.example.pos.mappers.SalesBilling.TransactionsMapper;
import com.example.pos.repositories.SalesBilling.TransactionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Transactions.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository repository;

    @Autowired
    private TransactionsMapper mapper;

    @Override
    public List<TransactionsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<TransactionsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public TransactionsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public TransactionsResponse create(TransactionsRequest request) {
        Transactions entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public TransactionsResponse update(Long id, TransactionsRequest request) {

        Transactions existing = repository.view(id).orElse(null);

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
