package com.example.pos.mappers.SalesBilling;

import com.example.pos.entities.SalesBilling.Invoices;
import com.example.pos.dtos.request.SalesBilling.InvoicesRequest;
import com.example.pos.dtos.response.SalesBilling.InvoicesResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoicesMapper {

    public InvoicesResponse toResponse(Invoices entity) {
        if (entity == null)
            return null;

        InvoicesResponse response = new InvoicesResponse();

        response.setId(entity.getId());
        response.setInvoiceNumber(entity.getInvoiceNumber());
        response.setTransactionId(entity.getTransactionId());
        response.setCustomerId(entity.getCustomerId());
        response.setTotalAmount(entity.getTotalAmount());
        response.setAmountPaid(entity.getAmountPaid());
        response.setBalanceDue(entity.getBalanceDue());
        response.setStatus(entity.getStatus());
        response.setDueDate(entity.getDueDate());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public Invoices toEntity(InvoicesRequest request) {
        if (request == null)
            return null;

        Invoices entity = new Invoices();

        entity.setInvoiceNumber(request.getInvoiceNumber());
        entity.setTransactionId(request.getTransactionId());
        entity.setCustomerId(request.getCustomerId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setAmountPaid(request.getAmountPaid());
        entity.setBalanceDue(request.getBalanceDue());
        entity.setStatus(request.getStatus());
        entity.setDueDate(request.getDueDate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(InvoicesRequest request, Invoices entity) {
        if (request == null || entity == null)
            return;

        entity.setInvoiceNumber(request.getInvoiceNumber());
        entity.setTransactionId(request.getTransactionId());
        entity.setCustomerId(request.getCustomerId());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setAmountPaid(request.getAmountPaid());
        entity.setBalanceDue(request.getBalanceDue());
        entity.setStatus(request.getStatus());
        entity.setDueDate(request.getDueDate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<InvoicesResponse> toResponseList(List<Invoices> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
