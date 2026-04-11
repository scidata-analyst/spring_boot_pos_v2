package com.example.pos.mappers.Dashboard;

import com.example.pos.entities.Dashboard.Dashboard;
import com.example.pos.dtos.request.Dashboard.DashboardRequest;
import com.example.pos.dtos.response.Dashboard.DashboardResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DashboardMapper {

    public DashboardResponse toResponse(Dashboard entity) {
        if (entity == null) return null;

        DashboardResponse response = new DashboardResponse();

        response.setId(entity.getId());
        response.setWidgetType(entity.getWidgetType());
        response.setTitle(entity.getTitle());
        response.setDataSource(entity.getDataSource());
        response.setConfiguration(entity.getConfiguration());
        response.setPosition(entity.getPosition());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public Dashboard toEntity(DashboardRequest request) {
        if (request == null) return null;

        Dashboard entity = new Dashboard();

        entity.setWidgetType(request.getWidgetType());
        entity.setTitle(request.getTitle());
        entity.setDataSource(request.getDataSource());
        entity.setConfiguration(request.getConfiguration());
        entity.setPosition(request.getPosition());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(DashboardRequest request, Dashboard entity) {
        if (request == null || entity == null) return;


        entity.setWidgetType(request.getWidgetType());
        entity.setTitle(request.getTitle());
        entity.setDataSource(request.getDataSource());
        entity.setConfiguration(request.getConfiguration());
        entity.setPosition(request.getPosition());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<DashboardResponse> toResponseList(List<Dashboard> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
