package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.DevicesPrinters;
import com.example.pos.dtos.request.Hardware.DevicesPrintersRequest;
import com.example.pos.dtos.response.Hardware.DevicesPrintersResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevicesPrintersMapper {

    public DevicesPrintersResponse toResponse(DevicesPrinters entity) {
        if (entity == null)
            return null;

        DevicesPrintersResponse response = new DevicesPrintersResponse();

        response.setId(entity.getId());
        response.setDeviceName(entity.getDeviceName());
        response.setDeviceType(entity.getDeviceType());
        response.setConnectionType(entity.getConnectionType());
        response.setIpAddress(entity.getIpAddress());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public DevicesPrinters toEntity(DevicesPrintersRequest request) {
        if (request == null)
            return null;

        DevicesPrinters entity = new DevicesPrinters();

        entity.setDeviceName(request.getDeviceName());
        entity.setDeviceType(request.getDeviceType());
        entity.setConnectionType(request.getConnectionType());
        entity.setIpAddress(request.getIpAddress());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(DevicesPrintersRequest request, DevicesPrinters entity) {
        if (request == null || entity == null)
            return;

        entity.setDeviceName(request.getDeviceName());
        entity.setDeviceType(request.getDeviceType());
        entity.setConnectionType(request.getConnectionType());
        entity.setIpAddress(request.getIpAddress());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<DevicesPrintersResponse> toResponseList(List<DevicesPrinters> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
