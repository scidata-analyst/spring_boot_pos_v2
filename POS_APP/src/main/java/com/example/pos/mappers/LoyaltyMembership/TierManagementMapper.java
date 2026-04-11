package com.example.pos.mappers.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.TierManagement;
import com.example.pos.dtos.request.LoyaltyMembership.TierManagementRequest;
import com.example.pos.dtos.response.LoyaltyMembership.TierManagementResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TierManagementMapper {

    public TierManagementResponse toResponse(TierManagement entity) {
        if (entity == null)
            return null;

        TierManagementResponse response = new TierManagementResponse();

        response.setId(entity.getId());
        response.setTierName(entity.getTierName());
        response.setMinPoints(entity.getMinPoints());
        response.setMaxPoints(entity.getMaxPoints());
        response.setDiscountPercentage(entity.getDiscountPercentage());
        response.setBenefits(entity.getBenefits());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public TierManagement toEntity(TierManagementRequest request) {
        if (request == null)
            return null;

        TierManagement entity = new TierManagement();

        entity.setTierName(request.getTierName());
        entity.setMinPoints(request.getMinPoints());
        entity.setMaxPoints(request.getMaxPoints());
        entity.setDiscountPercentage(request.getDiscountPercentage());
        entity.setBenefits(request.getBenefits());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(TierManagementRequest request, TierManagement entity) {
        if (request == null || entity == null)
            return;

        entity.setTierName(request.getTierName());
        entity.setMinPoints(request.getMinPoints());
        entity.setMaxPoints(request.getMaxPoints());
        entity.setDiscountPercentage(request.getDiscountPercentage());
        entity.setBenefits(request.getBenefits());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<TierManagementResponse> toResponseList(List<TierManagement> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
