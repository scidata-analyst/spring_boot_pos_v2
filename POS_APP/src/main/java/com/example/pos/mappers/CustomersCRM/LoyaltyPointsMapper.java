package com.example.pos.mappers.CustomersCRM;

import com.example.pos.entities.CustomersCRM.LoyaltyPoints;
import com.example.pos.dtos.request.CustomersCRM.LoyaltyPointsRequest;
import com.example.pos.dtos.response.CustomersCRM.LoyaltyPointsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoyaltyPointsMapper {

    public LoyaltyPointsResponse toResponse(LoyaltyPoints entity) {
        if (entity == null)
            return null;

        LoyaltyPointsResponse response = new LoyaltyPointsResponse();

        response.setId(entity.getId());
        response.setCustomerId(entity.getCustomerId());
        response.setPoints(entity.getPoints());
        response.setTransactionId(entity.getTransactionId());
        response.setType(entity.getType());
        response.setExpiryDate(entity.getExpiryDate());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public LoyaltyPoints toEntity(LoyaltyPointsRequest request) {
        if (request == null)
            return null;

        LoyaltyPoints entity = new LoyaltyPoints();

        entity.setCustomerId(request.getCustomerId());
        entity.setPoints(request.getPoints());
        entity.setTransactionId(request.getTransactionId());
        entity.setType(request.getType());
        entity.setExpiryDate(request.getExpiryDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(LoyaltyPointsRequest request, LoyaltyPoints entity) {
        if (request == null || entity == null)
            return;

        entity.setCustomerId(request.getCustomerId());
        entity.setPoints(request.getPoints());
        entity.setTransactionId(request.getTransactionId());
        entity.setType(request.getType());
        entity.setExpiryDate(request.getExpiryDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<LoyaltyPointsResponse> toResponseList(List<LoyaltyPoints> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
