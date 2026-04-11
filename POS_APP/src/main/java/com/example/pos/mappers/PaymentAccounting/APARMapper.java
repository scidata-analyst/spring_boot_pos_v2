package com.example.pos.mappers.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.APAR;
import com.example.pos.dtos.request.PaymentAccounting.APARRequest;
import com.example.pos.dtos.response.PaymentAccounting.APARResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class APARMapper {

    public APARResponse toResponse(APAR entity) {
        if (entity == null) return null;

        APARResponse response = new APARResponse();

        response.setId(entity.getId());
        response.setType(entity.getType());
        response.setReferenceId(entity.getReferenceId());
        response.setCustomerId(entity.getCustomerId());
        response.setSupplierId(entity.getSupplierId());
        response.setAmount(entity.getAmount());
        response.setDueDate(entity.getDueDate());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public APAR toEntity(APARRequest request) {
        if (request == null) return null;

        APAR entity = new APAR();

        entity.setType(request.getType());
        entity.setReferenceId(request.getReferenceId());
        entity.setCustomerId(request.getCustomerId());
        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setDueDate(request.getDueDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(APARRequest request, APAR entity) {
        if (request == null || entity == null) return;


        entity.setType(request.getType());
        entity.setReferenceId(request.getReferenceId());
        entity.setCustomerId(request.getCustomerId());
        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setDueDate(request.getDueDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<APARResponse> toResponseList(List<APAR> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
