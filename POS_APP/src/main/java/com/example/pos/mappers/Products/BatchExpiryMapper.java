package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.BatchExpiry;
import com.example.pos.dtos.request.Products.BatchExpiryRequest;
import com.example.pos.dtos.response.Products.BatchExpiryResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BatchExpiryMapper {

    public BatchExpiryResponse toResponse(BatchExpiry entity) {
        if (entity == null)
            return null;

        BatchExpiryResponse response = new BatchExpiryResponse();

        response.setId(entity.getId());
        response.setProductId(entity.getProductId());
        response.setBatchNumber(entity.getBatchNumber());
        response.setExpiryDate(entity.getExpiryDate());
        response.setManufacturingDate(entity.getManufacturingDate());
        response.setQuantity(entity.getQuantity());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public BatchExpiry toEntity(BatchExpiryRequest request) {
        if (request == null)
            return null;

        BatchExpiry entity = new BatchExpiry();

        entity.setProductId(request.getProductId());
        entity.setBatchNumber(request.getBatchNumber());
        entity.setExpiryDate(request.getExpiryDate());
        entity.setManufacturingDate(request.getManufacturingDate());
        entity.setQuantity(request.getQuantity());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(BatchExpiryRequest request, BatchExpiry entity) {
        if (request == null || entity == null)
            return;

        entity.setProductId(request.getProductId());
        entity.setBatchNumber(request.getBatchNumber());
        entity.setExpiryDate(request.getExpiryDate());
        entity.setManufacturingDate(request.getManufacturingDate());
        entity.setQuantity(request.getQuantity());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<BatchExpiryResponse> toResponseList(List<BatchExpiry> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
