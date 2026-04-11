package com.example.pos.mappers.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.StockReports;
import com.example.pos.dtos.request.ReportsAnalytics.StockReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.StockReportsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockReportsMapper {

    public StockReportsResponse toResponse(StockReports entity) {
        if (entity == null) return null;

        StockReportsResponse response = new StockReportsResponse();

        response.setId(entity.getId());
        response.setReportType(entity.getReportType());
        response.setTotalProducts(entity.getTotalProducts());
        response.setLowStockItems(entity.getLowStockItems());
        response.setOutOfStockItems(entity.getOutOfStockItems());
        response.setReportData(entity.getReportData());
        response.setGeneratedAt(entity.getGeneratedAt());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public StockReports toEntity(StockReportsRequest request) {
        if (request == null) return null;

        StockReports entity = new StockReports();

        entity.setReportType(request.getReportType());
        entity.setTotalProducts(request.getTotalProducts());
        entity.setLowStockItems(request.getLowStockItems());
        entity.setOutOfStockItems(request.getOutOfStockItems());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(StockReportsRequest request, StockReports entity) {
        if (request == null || entity == null) return;


        entity.setReportType(request.getReportType());
        entity.setTotalProducts(request.getTotalProducts());
        entity.setLowStockItems(request.getLowStockItems());
        entity.setOutOfStockItems(request.getOutOfStockItems());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<StockReportsResponse> toResponseList(List<StockReports> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
