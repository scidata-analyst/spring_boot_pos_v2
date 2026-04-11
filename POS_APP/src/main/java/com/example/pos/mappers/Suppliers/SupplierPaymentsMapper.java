package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.SupplierPayments;
import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierPaymentsMapper {

    public SupplierPaymentsResponse toResponse(SupplierPayments entity) {
        if (entity == null)
            return null;

        SupplierPaymentsResponse response = new SupplierPaymentsResponse();

        response.setId(entity.getId());
        response.setSupplierId(entity.getSupplierId());
        response.setAmount(entity.getAmount());
        response.setPaymentMethod(entity.getPaymentMethod());
        response.setReferenceNumber(entity.getReferenceNumber());
        response.setStatus(entity.getStatus());
        response.setPaymentDate(entity.getPaymentDate());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public SupplierPayments toEntity(SupplierPaymentsRequest request) {
        if (request == null)
            return null;

        SupplierPayments entity = new SupplierPayments();

        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setReferenceNumber(request.getReferenceNumber());
        entity.setStatus(request.getStatus());
        entity.setPaymentDate(request.getPaymentDate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(SupplierPaymentsRequest request, SupplierPayments entity) {
        if (request == null || entity == null)
            return;

        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setReferenceNumber(request.getReferenceNumber());
        entity.setStatus(request.getStatus());
        entity.setPaymentDate(request.getPaymentDate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<SupplierPaymentsResponse> toResponseList(List<SupplierPayments> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
