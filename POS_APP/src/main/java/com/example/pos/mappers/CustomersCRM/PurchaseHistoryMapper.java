package com.example.pos.mappers.CustomersCRM;

import com.example.pos.entities.CustomersCRM.PurchaseHistory;
import com.example.pos.dtos.request.CustomersCRM.PurchaseHistoryRequest;
import com.example.pos.dtos.response.CustomersCRM.PurchaseHistoryResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PurchaseHistoryMapper {

    public PurchaseHistoryResponse toResponse(PurchaseHistory entity) {
        if (entity == null)
            return null;

        PurchaseHistoryResponse response = new PurchaseHistoryResponse();

        response.setId(entity.getId());
        response.setCustomerId(entity.getCustomerId());
        response.setTransactionId(entity.getTransactionId());
        response.setTotalAmount(entity.getTotalAmount());
        response.setItems(entity.getItems());
        response.setPurchaseDate(entity.getPurchaseDate());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public PurchaseHistory toEntity(PurchaseHistoryRequest request) {
        if (request == null)
            return null;

        PurchaseHistory entity = new PurchaseHistory();

        entity.setCustomerId(request.getCustomerId());
        entity.setTransactionId(request.getTransactionId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setItems(request.getItems());
        entity.setPurchaseDate(request.getPurchaseDate());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(PurchaseHistoryRequest request, PurchaseHistory entity) {
        if (request == null || entity == null)
            return;

        entity.setCustomerId(request.getCustomerId());
        entity.setTransactionId(request.getTransactionId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setItems(request.getItems());
        entity.setPurchaseDate(request.getPurchaseDate());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<PurchaseHistoryResponse> toResponseList(List<PurchaseHistory> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
