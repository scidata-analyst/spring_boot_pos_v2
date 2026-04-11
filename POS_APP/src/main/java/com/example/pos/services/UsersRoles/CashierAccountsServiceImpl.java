package com.example.pos.services.UsersRoles;

import com.example.pos.entities.UsersRoles.CashierAccounts;
import com.example.pos.dtos.request.UsersRoles.CashierAccountsRequest;
import com.example.pos.dtos.response.UsersRoles.CashierAccountsResponse;
import com.example.pos.mappers.UsersRoles.CashierAccountsMapper;
import com.example.pos.repositories.UsersRoles.CashierAccountsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for CashierAccounts.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CashierAccountsServiceImpl implements CashierAccountsService {

    @Autowired
    private CashierAccountsRepository repository;

    @Autowired
    private CashierAccountsMapper mapper;

    @Override
    public List<CashierAccountsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<CashierAccountsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CashierAccountsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CashierAccountsResponse create(CashierAccountsRequest request) {
        CashierAccounts entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CashierAccountsResponse update(Long id, CashierAccountsRequest request) {

        CashierAccounts existing = repository.view(id).orElse(null);

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
