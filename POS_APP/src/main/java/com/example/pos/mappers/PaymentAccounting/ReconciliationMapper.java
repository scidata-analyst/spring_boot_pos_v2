package com.example.pos.mappers.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.Reconciliation;
import com.example.pos.dtos.request.PaymentAccounting.ReconciliationRequest;
import com.example.pos.dtos.response.PaymentAccounting.ReconciliationResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReconciliationMapper {

    public ReconciliationResponse toResponse(Reconciliation entity) {
        if (entity == null)
            return null;

        ReconciliationResponse response = new ReconciliationResponse();

        response.setId(entity.getId());
        response.setRegisterId(entity.getRegisterId());
        response.setExpectedAmount(entity.getExpectedAmount());
        response.setActualAmount(entity.getActualAmount());
        response.setVariance(entity.getVariance());
        response.setNotes(entity.getNotes());
        response.setStatus(entity.getStatus());
        response.setReconciledAt(entity.getReconciledAt());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public Reconciliation toEntity(ReconciliationRequest request) {
        if (request == null)
            return null;

        Reconciliation entity = new Reconciliation();

        entity.setRegisterId(request.getRegisterId());
        entity.setExpectedAmount(request.getExpectedAmount());
        entity.setActualAmount(request.getActualAmount());
        entity.setVariance(request.getVariance());
        entity.setNotes(request.getNotes());
        entity.setStatus(request.getStatus());
        entity.setReconciledAt(request.getReconciledAt());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(ReconciliationRequest request, Reconciliation entity) {
        if (request == null || entity == null)
            return;

        entity.setRegisterId(request.getRegisterId());
        entity.setExpectedAmount(request.getExpectedAmount());
        entity.setActualAmount(request.getActualAmount());
        entity.setVariance(request.getVariance());
        entity.setNotes(request.getNotes());
        entity.setStatus(request.getStatus());
        entity.setReconciledAt(request.getReconciledAt());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<ReconciliationResponse> toResponseList(List<Reconciliation> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
