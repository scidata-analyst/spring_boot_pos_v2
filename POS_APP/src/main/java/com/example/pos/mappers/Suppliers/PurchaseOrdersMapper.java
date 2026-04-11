package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.PurchaseOrders;
import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PurchaseOrdersMapper {

    public PurchaseOrdersResponse toResponse(PurchaseOrders entity) {
        if (entity == null) return null;

        PurchaseOrdersResponse response = new PurchaseOrdersResponse();

        response.setId(entity.getId());
        response.setSupplierId(entity.getSupplierId());
        response.setOrderNumber(entity.getOrderNumber());
        response.setTotalAmount(entity.getTotalAmount());
        response.setStatus(entity.getStatus());
        response.setOrderDate(entity.getOrderDate());
        response.setExpectedDelivery(entity.getExpectedDelivery());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public PurchaseOrders toEntity(PurchaseOrdersRequest request) {
        if (request == null) return null;

        PurchaseOrders entity = new PurchaseOrders();

        entity.setSupplierId(request.getSupplierId());
        entity.setOrderNumber(request.getOrderNumber());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setStatus(request.getStatus());
        entity.setOrderDate(request.getOrderDate());
        entity.setExpectedDelivery(request.getExpectedDelivery());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(PurchaseOrdersRequest request, PurchaseOrders entity) {
        if (request == null || entity == null) return;


        entity.setSupplierId(request.getSupplierId());
        entity.setOrderNumber(request.getOrderNumber());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setStatus(request.getStatus());
        entity.setOrderDate(request.getOrderDate());
        entity.setExpectedDelivery(request.getExpectedDelivery());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<PurchaseOrdersResponse> toResponseList(List<PurchaseOrders> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
