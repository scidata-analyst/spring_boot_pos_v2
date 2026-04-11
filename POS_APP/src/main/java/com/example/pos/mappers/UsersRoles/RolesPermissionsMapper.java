package com.example.pos.mappers.UsersRoles;

import com.example.pos.entities.UsersRoles.RolesPermissions;
import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolesPermissionsMapper {

    public RolesPermissionsResponse toResponse(RolesPermissions entity) {
        if (entity == null) return null;

        RolesPermissionsResponse response = new RolesPermissionsResponse();

        response.setId(entity.getId());
        response.setRoleName(entity.getRoleName());
        response.setPermissions(entity.getPermissions());
        response.setDescription(entity.getDescription());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public RolesPermissions toEntity(RolesPermissionsRequest request) {
        if (request == null) return null;

        RolesPermissions entity = new RolesPermissions();

        entity.setRoleName(request.getRoleName());
        entity.setPermissions(request.getPermissions());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(RolesPermissionsRequest request, RolesPermissions entity) {
        if (request == null || entity == null) return;


        entity.setRoleName(request.getRoleName());
        entity.setPermissions(request.getPermissions());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<RolesPermissionsResponse> toResponseList(List<RolesPermissions> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
