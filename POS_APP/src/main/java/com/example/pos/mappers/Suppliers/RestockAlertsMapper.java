package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.RestockAlerts;
import com.example.pos.dtos.request.Suppliers.RestockAlertsRequest;
import com.example.pos.dtos.response.Suppliers.RestockAlertsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestockAlertsMapper {

    public RestockAlertsResponse toResponse(RestockAlerts entity) {
        if (entity == null) return null;

        RestockAlertsResponse response = new RestockAlertsResponse();

        response.setId(entity.getId());
        response.setProductId(entity.getProductId());
        response.setCurrentStock(entity.getCurrentStock());
        response.setReorderLevel(entity.getReorderLevel());
        response.setStatus(entity.getStatus());
        response.setAlertDate(entity.getAlertDate());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public RestockAlerts toEntity(RestockAlertsRequest request) {
        if (request == null) return null;

        RestockAlerts entity = new RestockAlerts();

        entity.setProductId(request.getProductId());
        entity.setCurrentStock(request.getCurrentStock());
        entity.setReorderLevel(request.getReorderLevel());
        entity.setStatus(request.getStatus());
        entity.setAlertDate(request.getAlertDate());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(RestockAlertsRequest request, RestockAlerts entity) {
        if (request == null || entity == null) return;


        entity.setProductId(request.getProductId());
        entity.setCurrentStock(request.getCurrentStock());
        entity.setReorderLevel(request.getReorderLevel());
        entity.setStatus(request.getStatus());
        entity.setAlertDate(request.getAlertDate());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<RestockAlertsResponse> toResponseList(List<RestockAlerts> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
