package com.example.pos.mappers.SalesBilling;

import com.example.pos.entities.SalesBilling.ReturnsRefunds;
import com.example.pos.dtos.request.SalesBilling.ReturnsRefundsRequest;
import com.example.pos.dtos.response.SalesBilling.ReturnsRefundsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReturnsRefundsMapper {

    public ReturnsRefundsResponse toResponse(ReturnsRefunds entity) {
        if (entity == null)
            return null;

        ReturnsRefundsResponse response = new ReturnsRefundsResponse();

        response.setId(entity.getId());
        response.setTransactionId(entity.getTransactionId());
        response.setProductId(entity.getProductId());
        response.setQuantity(entity.getQuantity());
        response.setRefundAmount(entity.getRefundAmount());
        response.setReason(entity.getReason());
        response.setStatus(entity.getStatus());
        response.setReturnDate(entity.getReturnDate());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public ReturnsRefunds toEntity(ReturnsRefundsRequest request) {
        if (request == null)
            return null;

        ReturnsRefunds entity = new ReturnsRefunds();

        entity.setTransactionId(request.getTransactionId());
        entity.setProductId(request.getProductId());
        entity.setQuantity(request.getQuantity());
        entity.setRefundAmount(request.getRefundAmount());
        entity.setReason(request.getReason());
        entity.setStatus(request.getStatus());
        entity.setReturnDate(request.getReturnDate());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(ReturnsRefundsRequest request, ReturnsRefunds entity) {
        if (request == null || entity == null)
            return;

        entity.setTransactionId(request.getTransactionId());
        entity.setProductId(request.getProductId());
        entity.setQuantity(request.getQuantity());
        entity.setRefundAmount(request.getRefundAmount());
        entity.setReason(request.getReason());
        entity.setStatus(request.getStatus());
        entity.setReturnDate(request.getReturnDate());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<ReturnsRefundsResponse> toResponseList(List<ReturnsRefunds> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
