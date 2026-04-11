package com.example.pos.mappers.CustomersCRM;

import com.example.pos.entities.CustomersCRM.MembershipsVIP;
import com.example.pos.dtos.request.CustomersCRM.MembershipsVIPRequest;
import com.example.pos.dtos.response.CustomersCRM.MembershipsVIPResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MembershipsVIPMapper {

    public MembershipsVIPResponse toResponse(MembershipsVIP entity) {
        if (entity == null) return null;

        MembershipsVIPResponse response = new MembershipsVIPResponse();

        response.setId(entity.getId());
        response.setCustomerId(entity.getCustomerId());
        response.setMembershipType(entity.getMembershipType());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setBenefits(entity.getBenefits());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public MembershipsVIP toEntity(MembershipsVIPRequest request) {
        if (request == null) return null;

        MembershipsVIP entity = new MembershipsVIP();

        entity.setCustomerId(request.getCustomerId());
        entity.setMembershipType(request.getMembershipType());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setBenefits(request.getBenefits());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(MembershipsVIPRequest request, MembershipsVIP entity) {
        if (request == null || entity == null) return;


        entity.setCustomerId(request.getCustomerId());
        entity.setMembershipType(request.getMembershipType());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setBenefits(request.getBenefits());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<MembershipsVIPResponse> toResponseList(List<MembershipsVIP> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
