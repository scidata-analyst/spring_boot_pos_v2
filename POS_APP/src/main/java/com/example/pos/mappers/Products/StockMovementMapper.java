package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.StockMovement;
import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMovementMapper {

    public StockMovementResponse toResponse(StockMovement entity) {
        if (entity == null)
            return null;

        StockMovementResponse response = new StockMovementResponse();

        response.setId(entity.getId());
        response.setProductId(entity.getProductId());
        response.setType(entity.getType());
        response.setQuantity(entity.getQuantity());
        response.setReferenceId(entity.getReferenceId());
        response.setReason(entity.getReason());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public StockMovement toEntity(StockMovementRequest request) {
        if (request == null)
            return null;

        StockMovement entity = new StockMovement();

        entity.setProductId(request.getProductId());
        entity.setType(request.getType());
        entity.setQuantity(request.getQuantity());
        entity.setReferenceId(request.getReferenceId());
        entity.setReason(request.getReason());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(StockMovementRequest request, StockMovement entity) {
        if (request == null || entity == null)
            return;

        entity.setProductId(request.getProductId());
        entity.setType(request.getType());
        entity.setQuantity(request.getQuantity());
        entity.setReferenceId(request.getReferenceId());
        entity.setReason(request.getReason());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<StockMovementResponse> toResponseList(List<StockMovement> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
