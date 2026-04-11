package com.example.pos.services.UsersRoles;

import com.example.pos.entities.UsersRoles.ActivityLog;
import com.example.pos.dtos.request.UsersRoles.ActivityLogRequest;
import com.example.pos.dtos.response.UsersRoles.ActivityLogResponse;
import com.example.pos.mappers.UsersRoles.ActivityLogMapper;
import com.example.pos.repositories.UsersRoles.ActivityLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for ActivityLog.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository repository;

    @Autowired
    private ActivityLogMapper mapper;

    @Override
    public List<ActivityLogResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ActivityLogResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ActivityLogResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public ActivityLogResponse create(ActivityLogRequest request) {
        ActivityLog entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public ActivityLogResponse update(Long id, ActivityLogRequest request) {

        ActivityLog existing = repository.view(id).orElse(null);

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
