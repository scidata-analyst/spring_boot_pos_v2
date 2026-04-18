package com.example.pos.services.Hardware;

import com.example.pos.entities.Hardware.DevicesPrinters;
import com.example.pos.dtos.request.Hardware.DevicesPrintersRequest;
import com.example.pos.dtos.response.Hardware.DevicesPrintersResponse;
import com.example.pos.mappers.Hardware.DevicesPrintersMapper;
import com.example.pos.repositories.Hardware.DevicesPrintersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for DevicesPrinters.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class DevicesPrintersServiceImpl implements DevicesPrintersService {

    @Autowired
    private DevicesPrintersRepository repository;

    @Autowired
    private DevicesPrintersMapper mapper;

    @Override
    public List<DevicesPrintersResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<DevicesPrintersResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public DevicesPrintersResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public DevicesPrintersResponse create(DevicesPrintersRequest request) {
        DevicesPrinters entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public DevicesPrintersResponse update(Long id, DevicesPrintersRequest request) {

        DevicesPrinters existing = repository.view(id).orElse(null);

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
