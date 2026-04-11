package com.example.pos.mappers.SalesBilling;

import com.example.pos.entities.SalesBilling.Transactions;
import com.example.pos.dtos.request.SalesBilling.TransactionsRequest;
import com.example.pos.dtos.response.SalesBilling.TransactionsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionsMapper {

    public TransactionsResponse toResponse(Transactions entity) {
        if (entity == null) return null;

        TransactionsResponse response = new TransactionsResponse();

        response.setId(entity.getId());
        response.setInvoiceNumber(entity.getInvoiceNumber());
        response.setCustomerId(entity.getCustomerId());
        response.setSubtotal(entity.getSubtotal());
        response.setTax(entity.getTax());
        response.setDiscount(entity.getDiscount());
        response.setTotalAmount(entity.getTotalAmount());
        response.setPaymentMethod(entity.getPaymentMethod());
        response.setCashierId(entity.getCashierId());
        response.setStatus(entity.getStatus());
        response.setTransactionDate(entity.getTransactionDate());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public Transactions toEntity(TransactionsRequest request) {
        if (request == null) return null;

        Transactions entity = new Transactions();

        entity.setInvoiceNumber(request.getInvoiceNumber());
        entity.setCustomerId(request.getCustomerId());
        entity.setSubtotal(request.getSubtotal());
        entity.setTax(request.getTax());
        entity.setDiscount(request.getDiscount());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setCashierId(request.getCashierId());
        entity.setStatus(request.getStatus());
        entity.setTransactionDate(request.getTransactionDate());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(TransactionsRequest request, Transactions entity) {
        if (request == null || entity == null) return;


        entity.setInvoiceNumber(request.getInvoiceNumber());
        entity.setCustomerId(request.getCustomerId());
        entity.setSubtotal(request.getSubtotal());
        entity.setTax(request.getTax());
        entity.setDiscount(request.getDiscount());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setCashierId(request.getCashierId());
        entity.setStatus(request.getStatus());
        entity.setTransactionDate(request.getTransactionDate());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<TransactionsResponse> toResponseList(List<Transactions> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
