package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.CashDrawer;
import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CashDrawerMapper {

    public CashDrawerResponse toResponse(CashDrawer entity) {
        if (entity == null)
            return null;

        CashDrawerResponse response = new CashDrawerResponse();

        response.setId(entity.getId());
        response.setDrawerNumber(entity.getDrawerNumber());
        response.setStatus(entity.getStatus());
        response.setConnectedDevice(entity.getConnectedDevice());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public CashDrawer toEntity(CashDrawerRequest request) {
        if (request == null)
            return null;

        CashDrawer entity = new CashDrawer();

        entity.setDrawerNumber(request.getDrawerNumber());
        entity.setStatus(request.getStatus());
        entity.setConnectedDevice(request.getConnectedDevice());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CashDrawerRequest request, CashDrawer entity) {
        if (request == null || entity == null)
            return;

        entity.setDrawerNumber(request.getDrawerNumber());
        entity.setStatus(request.getStatus());
        entity.setConnectedDevice(request.getConnectedDevice());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CashDrawerResponse> toResponseList(List<CashDrawer> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
