package com.example.pos.mappers.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.PointsConfig;
import com.example.pos.dtos.request.LoyaltyMembership.PointsConfigRequest;
import com.example.pos.dtos.response.LoyaltyMembership.PointsConfigResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PointsConfigMapper {

    public PointsConfigResponse toResponse(PointsConfig entity) {
        if (entity == null)
            return null;

        PointsConfigResponse response = new PointsConfigResponse();

        response.setId(entity.getId());
        response.setPointsPerDollar(entity.getPointsPerDollar());
        response.setRedemptionRate(entity.getRedemptionRate());
        response.setMinimumRedemption(entity.getMinimumRedemption());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public PointsConfig toEntity(PointsConfigRequest request) {
        if (request == null)
            return null;

        PointsConfig entity = new PointsConfig();

        entity.setPointsPerDollar(request.getPointsPerDollar());
        entity.setRedemptionRate(request.getRedemptionRate());
        entity.setMinimumRedemption(request.getMinimumRedemption());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(PointsConfigRequest request, PointsConfig entity) {
        if (request == null || entity == null)
            return;

        entity.setPointsPerDollar(request.getPointsPerDollar());
        entity.setRedemptionRate(request.getRedemptionRate());
        entity.setMinimumRedemption(request.getMinimumRedemption());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<PointsConfigResponse> toResponseList(List<PointsConfig> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
