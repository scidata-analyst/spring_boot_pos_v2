package com.example.pos.services.UsersRoles;

import com.example.pos.entities.UsersRoles.RolesPermissions;
import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;
import com.example.pos.mappers.UsersRoles.RolesPermissionsMapper;
import com.example.pos.repositories.UsersRoles.RolesPermissionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for RolesPermissions.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class RolesPermissionsServiceImpl implements RolesPermissionsService {

    @Autowired
    private RolesPermissionsRepository repository;

    @Autowired
    private RolesPermissionsMapper mapper;

    @Override
    public List<RolesPermissionsResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<RolesPermissionsResponse> index(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public RolesPermissionsResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public RolesPermissionsResponse create(RolesPermissionsRequest request) {
        RolesPermissions entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public RolesPermissionsResponse update(Long id, RolesPermissionsRequest request) {

        RolesPermissions existing = repository.view(id).orElse(null);

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
