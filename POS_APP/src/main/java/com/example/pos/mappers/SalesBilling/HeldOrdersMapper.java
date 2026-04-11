package com.example.pos.mappers.SalesBilling;

import com.example.pos.entities.SalesBilling.HeldOrders;
import com.example.pos.dtos.request.SalesBilling.HeldOrdersRequest;
import com.example.pos.dtos.response.SalesBilling.HeldOrdersResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HeldOrdersMapper {

    public HeldOrdersResponse toResponse(HeldOrders entity) {
        if (entity == null)
            return null;

        HeldOrdersResponse response = new HeldOrdersResponse();

        response.setId(entity.getId());
        response.setOrderNumber(entity.getOrderNumber());
        response.setCartData(entity.getCartData());
        response.setCashierId(entity.getCashierId());
        response.setTotalAmount(entity.getTotalAmount());
        response.setHoldDate(entity.getHoldDate());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public HeldOrders toEntity(HeldOrdersRequest request) {
        if (request == null)
            return null;

        HeldOrders entity = new HeldOrders();

        entity.setOrderNumber(request.getOrderNumber());
        entity.setCartData(request.getCartData());
        entity.setCashierId(request.getCashierId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setHoldDate(request.getHoldDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(HeldOrdersRequest request, HeldOrders entity) {
        if (request == null || entity == null)
            return;

        entity.setOrderNumber(request.getOrderNumber());
        entity.setCartData(request.getCartData());
        entity.setCashierId(request.getCashierId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setHoldDate(request.getHoldDate());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<HeldOrdersResponse> toResponseList(List<HeldOrders> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
