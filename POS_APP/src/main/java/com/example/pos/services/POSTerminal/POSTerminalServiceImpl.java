package com.example.pos.services.POSTerminal;

import com.example.pos.entities.POSTerminal.POSTerminal;
import com.example.pos.dtos.request.POSTerminal.POSTerminalRequest;
import com.example.pos.dtos.response.POSTerminal.POSTerminalResponse;
import com.example.pos.mappers.POSTerminal.POSTerminalMapper;
import com.example.pos.repositories.POSTerminal.POSTerminalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for POSTerminal.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class POSTerminalServiceImpl implements POSTerminalService {

    @Autowired
    private POSTerminalRepository repository;

    @Autowired
    private POSTerminalMapper mapper;

    @Override
    public List<POSTerminalResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<POSTerminalResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public POSTerminalResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public POSTerminalResponse create(POSTerminalRequest request) {
        POSTerminal entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public POSTerminalResponse update(Long id, POSTerminalRequest request) {

        POSTerminal existing = repository.view(id).orElse(null);

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
