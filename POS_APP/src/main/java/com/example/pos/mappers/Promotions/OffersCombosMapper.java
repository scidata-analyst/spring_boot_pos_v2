package com.example.pos.mappers.Promotions;

import com.example.pos.entities.Promotions.OffersCombos;
import com.example.pos.dtos.request.Promotions.OffersCombosRequest;
import com.example.pos.dtos.response.Promotions.OffersCombosResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OffersCombosMapper {

    public OffersCombosResponse toResponse(OffersCombos entity) {
        if (entity == null)
            return null;

        OffersCombosResponse response = new OffersCombosResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setType(entity.getType());
        response.setDiscount(entity.getDiscount());
        response.setProductId(entity.getProductId());
        response.setAppliesTo(entity.getAppliesTo());
        response.setStatus(entity.getStatus());
        response.setMinQuantity(entity.getMinQuantity());
        response.setValidPeriod(entity.getValidPeriod());
        response.setUsed(entity.getUsed());
        response.setUsageLimit(entity.getUsageLimit());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public OffersCombos toEntity(OffersCombosRequest request) {
        if (request == null)
            return null;

        OffersCombos entity = new OffersCombos();

        entity.setName(request.getName());
        entity.setType(request.getType());
        entity.setDiscount(request.getDiscount());
        entity.setProductId(request.getProductId());
        entity.setAppliesTo(request.getAppliesTo());
        entity.setStatus(request.getStatus());
        entity.setMinQuantity(request.getMinQuantity());
        entity.setValidPeriod(request.getValidPeriod());
        entity.setUsed(request.getUsed());
        entity.setUsageLimit(request.getUsageLimit());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(OffersCombosRequest request, OffersCombos entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setType(request.getType());
        entity.setDiscount(request.getDiscount());
        entity.setProductId(request.getProductId());
        entity.setAppliesTo(request.getAppliesTo());
        entity.setStatus(request.getStatus());
        entity.setMinQuantity(request.getMinQuantity());
        entity.setValidPeriod(request.getValidPeriod());
        entity.setUsed(request.getUsed());
        entity.setUsageLimit(request.getUsageLimit());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<OffersCombosResponse> toResponseList(List<OffersCombos> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
