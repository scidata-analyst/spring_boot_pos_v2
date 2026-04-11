package com.example.pos.services.SalesBilling;

import com.example.pos.entities.SalesBilling.ReturnsRefunds;
import com.example.pos.dtos.request.SalesBilling.ReturnsRefundsRequest;
import com.example.pos.dtos.response.SalesBilling.ReturnsRefundsResponse;
import com.example.pos.mappers.SalesBilling.ReturnsRefundsMapper;
import com.example.pos.repositories.SalesBilling.ReturnsRefundsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for ReturnsRefunds.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class ReturnsRefundsServiceImpl implements ReturnsRefundsService {

    @Autowired
    private ReturnsRefundsRepository repository;

    @Autowired
    private ReturnsRefundsMapper mapper;

    @Override
    public List<ReturnsRefundsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ReturnsRefundsResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ReturnsRefundsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public ReturnsRefundsResponse create(ReturnsRefundsRequest request) {
        ReturnsRefunds entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public ReturnsRefundsResponse update(Long id, ReturnsRefundsRequest request) {

        ReturnsRefunds existing = repository.view(id).orElse(null);

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
