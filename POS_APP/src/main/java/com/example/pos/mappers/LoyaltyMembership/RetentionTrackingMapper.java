package com.example.pos.mappers.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.RetentionTracking;
import com.example.pos.dtos.request.LoyaltyMembership.RetentionTrackingRequest;
import com.example.pos.dtos.response.LoyaltyMembership.RetentionTrackingResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetentionTrackingMapper {

    public RetentionTrackingResponse toResponse(RetentionTracking entity) {
        if (entity == null) return null;

        RetentionTrackingResponse response = new RetentionTrackingResponse();

        response.setId(entity.getId());
        response.setCustomerId(entity.getCustomerId());
        response.setLastPurchaseDate(entity.getLastPurchaseDate());
        response.setDaysSinceLastPurchase(entity.getDaysSinceLastPurchase());
        response.setChurnRisk(entity.getChurnRisk());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public RetentionTracking toEntity(RetentionTrackingRequest request) {
        if (request == null) return null;

        RetentionTracking entity = new RetentionTracking();

        entity.setCustomerId(request.getCustomerId());
        entity.setLastPurchaseDate(request.getLastPurchaseDate());
        entity.setDaysSinceLastPurchase(request.getDaysSinceLastPurchase());
        entity.setChurnRisk(request.getChurnRisk());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(RetentionTrackingRequest request, RetentionTracking entity) {
        if (request == null || entity == null) return;


        entity.setCustomerId(request.getCustomerId());
        entity.setLastPurchaseDate(request.getLastPurchaseDate());
        entity.setDaysSinceLastPurchase(request.getDaysSinceLastPurchase());
        entity.setChurnRisk(request.getChurnRisk());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<RetentionTrackingResponse> toResponseList(List<RetentionTracking> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
