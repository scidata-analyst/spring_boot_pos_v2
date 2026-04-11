package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.BarcodeSKU;
import com.example.pos.dtos.request.Products.BarcodeSKURequest;
import com.example.pos.dtos.response.Products.BarcodeSKUResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BarcodeSKUMapper {

    public BarcodeSKUResponse toResponse(BarcodeSKU entity) {
        if (entity == null)
            return null;

        BarcodeSKUResponse response = new BarcodeSKUResponse();

        response.setId(entity.getId());
        response.setBarcode(entity.getBarcode());
        response.setSku(entity.getSku());
        response.setProductId(entity.getProductId());
        response.setVariant(entity.getVariant());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public BarcodeSKU toEntity(BarcodeSKURequest request) {
        if (request == null)
            return null;

        BarcodeSKU entity = new BarcodeSKU();

        entity.setBarcode(request.getBarcode());
        entity.setSku(request.getSku());
        entity.setProductId(request.getProductId());
        entity.setVariant(request.getVariant());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(BarcodeSKURequest request, BarcodeSKU entity) {
        if (request == null || entity == null)
            return;

        entity.setBarcode(request.getBarcode());
        entity.setSku(request.getSku());
        entity.setProductId(request.getProductId());
        entity.setVariant(request.getVariant());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<BarcodeSKUResponse> toResponseList(List<BarcodeSKU> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
