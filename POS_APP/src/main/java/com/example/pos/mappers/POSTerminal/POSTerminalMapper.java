package com.example.pos.mappers.POSTerminal;

import com.example.pos.entities.POSTerminal.POSTerminal;
import com.example.pos.dtos.request.POSTerminal.POSTerminalRequest;
import com.example.pos.dtos.response.POSTerminal.POSTerminalResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class POSTerminalMapper {

    public POSTerminalResponse toResponse(POSTerminal entity) {
        if (entity == null) return null;

        POSTerminalResponse response = new POSTerminalResponse();

        response.setId(entity.getId());
        response.setTerminalName(entity.getTerminalName());
        response.setTerminalCode(entity.getTerminalCode());
        response.setStoreId(entity.getStoreId());
        response.setStatus(entity.getStatus());
        response.setLastSync(entity.getLastSync());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public POSTerminal toEntity(POSTerminalRequest request) {
        if (request == null) return null;

        POSTerminal entity = new POSTerminal();

        entity.setTerminalName(request.getTerminalName());
        entity.setTerminalCode(request.getTerminalCode());
        entity.setStoreId(request.getStoreId());
        entity.setStatus(request.getStatus());
        entity.setLastSync(request.getLastSync());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(POSTerminalRequest request, POSTerminal entity) {
        if (request == null || entity == null) return;


        entity.setTerminalName(request.getTerminalName());
        entity.setTerminalCode(request.getTerminalCode());
        entity.setStoreId(request.getStoreId());
        entity.setStatus(request.getStatus());
        entity.setLastSync(request.getLastSync());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<POSTerminalResponse> toResponseList(List<POSTerminal> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
