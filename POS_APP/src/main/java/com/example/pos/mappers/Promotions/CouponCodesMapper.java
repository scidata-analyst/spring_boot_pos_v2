package com.example.pos.mappers.Promotions;

import com.example.pos.entities.Promotions.CouponCodes;
import com.example.pos.dtos.request.Promotions.CouponCodesRequest;
import com.example.pos.dtos.response.Promotions.CouponCodesResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouponCodesMapper {

    public CouponCodesResponse toResponse(CouponCodes entity) {
        if (entity == null)
            return null;

        CouponCodesResponse response = new CouponCodesResponse();

        response.setId(entity.getId());
        response.setCode(entity.getCode());
        response.setDiscountType(entity.getDiscountType());
        response.setDiscountValue(entity.getDiscountValue());
        response.setMinOrderAmount(entity.getMinOrderAmount());
        response.setMaxUses(entity.getMaxUses());
        response.setUsedCount(entity.getUsedCount());
        response.setValidFrom(entity.getValidFrom());
        response.setValidUntil(entity.getValidUntil());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public CouponCodes toEntity(CouponCodesRequest request) {
        if (request == null)
            return null;

        CouponCodes entity = new CouponCodes();

        entity.setCode(request.getCode());
        entity.setDiscountType(request.getDiscountType());
        entity.setDiscountValue(request.getDiscountValue());
        entity.setMinOrderAmount(request.getMinOrderAmount());
        entity.setMaxUses(request.getMaxUses());
        entity.setUsedCount(request.getUsedCount());
        entity.setValidFrom(request.getValidFrom());
        entity.setValidUntil(request.getValidUntil());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CouponCodesRequest request, CouponCodes entity) {
        if (request == null || entity == null)
            return;

        entity.setCode(request.getCode());
        entity.setDiscountType(request.getDiscountType());
        entity.setDiscountValue(request.getDiscountValue());
        entity.setMinOrderAmount(request.getMinOrderAmount());
        entity.setMaxUses(request.getMaxUses());
        entity.setUsedCount(request.getUsedCount());
        entity.setValidFrom(request.getValidFrom());
        entity.setValidUntil(request.getValidUntil());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CouponCodesResponse> toResponseList(List<CouponCodes> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
