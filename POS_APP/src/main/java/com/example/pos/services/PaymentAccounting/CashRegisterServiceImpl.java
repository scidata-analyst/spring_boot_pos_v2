package com.example.pos.services.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.CashRegister;
import com.example.pos.dtos.request.PaymentAccounting.CashRegisterRequest;
import com.example.pos.dtos.response.PaymentAccounting.CashRegisterResponse;
import com.example.pos.mappers.PaymentAccounting.CashRegisterMapper;
import com.example.pos.repositories.PaymentAccounting.CashRegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for CashRegister.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CashRegisterServiceImpl implements CashRegisterService {

    @Autowired
    private CashRegisterRepository repository;

    @Autowired
    private CashRegisterMapper mapper;

    @Override
    public List<CashRegisterResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<CashRegisterResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CashRegisterResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CashRegisterResponse create(CashRegisterRequest request) {
        CashRegister entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CashRegisterResponse update(Long id, CashRegisterRequest request) {

        CashRegister existing = repository.view(id).orElse(null);

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
