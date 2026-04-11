package com.example.pos.mappers.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.CustomBuilder;
import com.example.pos.dtos.request.ReportsAnalytics.CustomBuilderRequest;
import com.example.pos.dtos.response.ReportsAnalytics.CustomBuilderResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomBuilderMapper {

    public CustomBuilderResponse toResponse(CustomBuilder entity) {
        if (entity == null) return null;

        CustomBuilderResponse response = new CustomBuilderResponse();

        response.setId(entity.getId());
        response.setReportName(entity.getReportName());
        response.setQueryConfig(entity.getQueryConfig());
        response.setChartType(entity.getChartType());
        response.setFilters(entity.getFilters());
        response.setCreatedBy(entity.getCreatedBy());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public CustomBuilder toEntity(CustomBuilderRequest request) {
        if (request == null) return null;

        CustomBuilder entity = new CustomBuilder();

        entity.setReportName(request.getReportName());
        entity.setQueryConfig(request.getQueryConfig());
        entity.setChartType(request.getChartType());
        entity.setFilters(request.getFilters());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CustomBuilderRequest request, CustomBuilder entity) {
        if (request == null || entity == null) return;


        entity.setReportName(request.getReportName());
        entity.setQueryConfig(request.getQueryConfig());
        entity.setChartType(request.getChartType());
        entity.setFilters(request.getFilters());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CustomBuilderResponse> toResponseList(List<CustomBuilder> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
