package com.example.pos.mappers.Promotions;

import com.example.pos.entities.Promotions.HappyHour;
import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HappyHourMapper {

    public HappyHourResponse toResponse(HappyHour entity) {
        if (entity == null)
            return null;

        HappyHourResponse response = new HappyHourResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setStartTime(entity.getStartTime());
        response.setEndTime(entity.getEndTime());
        response.setDaysOfWeek(entity.getDaysOfWeek());
        response.setDiscountPercentage(entity.getDiscountPercentage());
        response.setApplicableProducts(entity.getApplicableProducts());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public HappyHour toEntity(HappyHourRequest request) {
        if (request == null)
            return null;

        HappyHour entity = new HappyHour();

        entity.setName(request.getName());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        entity.setDaysOfWeek(request.getDaysOfWeek());
        entity.setDiscountPercentage(request.getDiscountPercentage());
        entity.setApplicableProducts(request.getApplicableProducts());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(HappyHourRequest request, HappyHour entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        entity.setDaysOfWeek(request.getDaysOfWeek());
        entity.setDiscountPercentage(request.getDiscountPercentage());
        entity.setApplicableProducts(request.getApplicableProducts());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<HappyHourResponse> toResponseList(List<HappyHour> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
