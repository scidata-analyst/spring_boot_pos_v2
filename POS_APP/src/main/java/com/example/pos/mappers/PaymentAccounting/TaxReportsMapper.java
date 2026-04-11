package com.example.pos.mappers.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.TaxReports;
import com.example.pos.dtos.request.PaymentAccounting.TaxReportsRequest;
import com.example.pos.dtos.response.PaymentAccounting.TaxReportsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaxReportsMapper {

    public TaxReportsResponse toResponse(TaxReports entity) {
        if (entity == null)
            return null;

        TaxReportsResponse response = new TaxReportsResponse();

        response.setId(entity.getId());
        response.setTaxType(entity.getTaxType());
        response.setTaxRate(entity.getTaxRate());
        response.setTaxableAmount(entity.getTaxableAmount());
        response.setTaxAmount(entity.getTaxAmount());
        response.setPeriod(entity.getPeriod());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public TaxReports toEntity(TaxReportsRequest request) {
        if (request == null)
            return null;

        TaxReports entity = new TaxReports();

        entity.setTaxType(request.getTaxType());
        entity.setTaxRate(request.getTaxRate());
        entity.setTaxableAmount(request.getTaxableAmount());
        entity.setTaxAmount(request.getTaxAmount());
        entity.setPeriod(request.getPeriod());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(TaxReportsRequest request, TaxReports entity) {
        if (request == null || entity == null)
            return;

        entity.setTaxType(request.getTaxType());
        entity.setTaxRate(request.getTaxRate());
        entity.setTaxableAmount(request.getTaxableAmount());
        entity.setTaxAmount(request.getTaxAmount());
        entity.setPeriod(request.getPeriod());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<TaxReportsResponse> toResponseList(List<TaxReports> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
