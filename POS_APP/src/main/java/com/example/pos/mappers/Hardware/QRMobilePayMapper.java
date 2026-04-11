package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.QRMobilePay;
import com.example.pos.dtos.request.Hardware.QRMobilePayRequest;
import com.example.pos.dtos.response.Hardware.QRMobilePayResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QRMobilePayMapper {

    public QRMobilePayResponse toResponse(QRMobilePay entity) {
        if (entity == null)
            return null;

        QRMobilePayResponse response = new QRMobilePayResponse();

        response.setId(entity.getId());
        response.setPaymentMethod(entity.getPaymentMethod());
        response.setQrCode(entity.getQrCode());
        response.setMerchantId(entity.getMerchantId());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public QRMobilePay toEntity(QRMobilePayRequest request) {
        if (request == null)
            return null;

        QRMobilePay entity = new QRMobilePay();

        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setQrCode(request.getQrCode());
        entity.setMerchantId(request.getMerchantId());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(QRMobilePayRequest request, QRMobilePay entity) {
        if (request == null || entity == null)
            return;

        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setQrCode(request.getQrCode());
        entity.setMerchantId(request.getMerchantId());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<QRMobilePayResponse> toResponseList(List<QRMobilePay> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
