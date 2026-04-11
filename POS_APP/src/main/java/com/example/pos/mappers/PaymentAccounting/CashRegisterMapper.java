package com.example.pos.mappers.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.CashRegister;
import com.example.pos.dtos.request.PaymentAccounting.CashRegisterRequest;
import com.example.pos.dtos.response.PaymentAccounting.CashRegisterResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CashRegisterMapper {

    public CashRegisterResponse toResponse(CashRegister entity) {
        if (entity == null) return null;

        CashRegisterResponse response = new CashRegisterResponse();

        response.setId(entity.getId());
        response.setRegisterName(entity.getRegisterName());
        response.setOpeningBalance(entity.getOpeningBalance());
        response.setClosingBalance(entity.getClosingBalance());
        response.setCashIn(entity.getCashIn());
        response.setCashOut(entity.getCashOut());
        response.setStatus(entity.getStatus());
        response.setOpenedAt(entity.getOpenedAt());
        response.setClosedAt(entity.getClosedAt());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public CashRegister toEntity(CashRegisterRequest request) {
        if (request == null) return null;

        CashRegister entity = new CashRegister();

        entity.setRegisterName(request.getRegisterName());
        entity.setOpeningBalance(request.getOpeningBalance());
        entity.setClosingBalance(request.getClosingBalance());
        entity.setCashIn(request.getCashIn());
        entity.setCashOut(request.getCashOut());
        entity.setStatus(request.getStatus());
        entity.setOpenedAt(request.getOpenedAt());
        entity.setClosedAt(request.getClosedAt());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(CashRegisterRequest request, CashRegister entity) {
        if (request == null || entity == null) return;


        entity.setRegisterName(request.getRegisterName());
        entity.setOpeningBalance(request.getOpeningBalance());
        entity.setClosingBalance(request.getClosingBalance());
        entity.setCashIn(request.getCashIn());
        entity.setCashOut(request.getCashOut());
        entity.setStatus(request.getStatus());
        entity.setOpenedAt(request.getOpenedAt());
        entity.setClosedAt(request.getClosedAt());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<CashRegisterResponse> toResponseList(List<CashRegister> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
