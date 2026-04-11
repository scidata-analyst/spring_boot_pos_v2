package com.example.pos.services.Promotions;

import com.example.pos.entities.Promotions.HappyHour;
import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;
import com.example.pos.mappers.Promotions.HappyHourMapper;
import com.example.pos.repositories.Promotions.HappyHourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for HappyHour.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class HappyHourServiceImpl implements HappyHourService {

    @Autowired
    private HappyHourRepository repository;

    @Autowired
    private HappyHourMapper mapper;

    @Override
    public List<HappyHourResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<HappyHourResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public HappyHourResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public HappyHourResponse create(HappyHourRequest request) {
        HappyHour entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public HappyHourResponse update(Long id, HappyHourRequest request) {

        HappyHour existing = repository.view(id).orElse(null);

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
