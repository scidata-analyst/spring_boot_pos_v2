package com.example.pos.services.Promotions;

import com.example.pos.entities.Promotions.OffersCombos;
import com.example.pos.dtos.request.Promotions.OffersCombosRequest;
import com.example.pos.dtos.response.Promotions.OffersCombosResponse;
import com.example.pos.mappers.Promotions.OffersCombosMapper;
import com.example.pos.repositories.Promotions.OffersCombosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for OffersCombos.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class OffersCombosServiceImpl implements OffersCombosService {

    @Autowired
    private OffersCombosRepository repository;

    @Autowired
    private OffersCombosMapper mapper;

    @Override
    public List<OffersCombosResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<OffersCombosResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public OffersCombosResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public OffersCombosResponse create(OffersCombosRequest request) {
        OffersCombos entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public OffersCombosResponse update(Long id, OffersCombosRequest request) {

        OffersCombos existing = repository.view(id).orElse(null);

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
