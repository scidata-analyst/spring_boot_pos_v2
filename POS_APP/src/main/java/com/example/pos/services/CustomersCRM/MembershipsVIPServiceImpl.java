package com.example.pos.services.CustomersCRM;

import com.example.pos.entities.CustomersCRM.MembershipsVIP;
import com.example.pos.dtos.request.CustomersCRM.MembershipsVIPRequest;
import com.example.pos.dtos.response.CustomersCRM.MembershipsVIPResponse;
import com.example.pos.mappers.CustomersCRM.MembershipsVIPMapper;
import com.example.pos.repositories.CustomersCRM.MembershipsVIPRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for MembershipsVIP.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class MembershipsVIPServiceImpl implements MembershipsVIPService {

    @Autowired
    private MembershipsVIPRepository repository;

    @Autowired
    private MembershipsVIPMapper mapper;

    @Override
    public List<MembershipsVIPResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<MembershipsVIPResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public MembershipsVIPResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public MembershipsVIPResponse create(MembershipsVIPRequest request) {
        MembershipsVIP entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public MembershipsVIPResponse update(Long id, MembershipsVIPRequest request) {

        MembershipsVIP existing = repository.view(id).orElse(null);

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
