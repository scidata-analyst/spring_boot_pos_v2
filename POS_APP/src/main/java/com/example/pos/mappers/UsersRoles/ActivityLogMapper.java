package com.example.pos.mappers.UsersRoles;

import com.example.pos.entities.UsersRoles.ActivityLog;
import com.example.pos.dtos.request.UsersRoles.ActivityLogRequest;
import com.example.pos.dtos.response.UsersRoles.ActivityLogResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityLogMapper {

    public ActivityLogResponse toResponse(ActivityLog entity) {
        if (entity == null) return null;

        ActivityLogResponse response = new ActivityLogResponse();

        response.setId(entity.getId());
        response.setUserId(entity.getUserId());
        response.setAction(entity.getAction());
        response.setModule(entity.getModule());
        response.setDescription(entity.getDescription());
        response.setIpAddress(entity.getIpAddress());
        response.setTimestamp(entity.getTimestamp());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public ActivityLog toEntity(ActivityLogRequest request) {
        if (request == null) return null;

        ActivityLog entity = new ActivityLog();

        entity.setUserId(request.getUserId());
        entity.setAction(request.getAction());
        entity.setModule(request.getModule());
        entity.setDescription(request.getDescription());
        entity.setIpAddress(request.getIpAddress());
        entity.setTimestamp(request.getTimestamp());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(ActivityLogRequest request, ActivityLog entity) {
        if (request == null || entity == null) return;


        entity.setUserId(request.getUserId());
        entity.setAction(request.getAction());
        entity.setModule(request.getModule());
        entity.setDescription(request.getDescription());
        entity.setIpAddress(request.getIpAddress());
        entity.setTimestamp(request.getTimestamp());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<ActivityLogResponse> toResponseList(List<ActivityLog> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
