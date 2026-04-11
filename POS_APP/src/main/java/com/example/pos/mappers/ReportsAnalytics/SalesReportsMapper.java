package com.example.pos.mappers.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.SalesReports;
import com.example.pos.dtos.request.ReportsAnalytics.SalesReportsRequest;
import com.example.pos.dtos.response.ReportsAnalytics.SalesReportsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SalesReportsMapper {

    public SalesReportsResponse toResponse(SalesReports entity) {
        if (entity == null)
            return null;

        SalesReportsResponse response = new SalesReportsResponse();

        response.setId(entity.getId());
        response.setReportType(entity.getReportType());
        response.setPeriod(entity.getPeriod());
        response.setTotalSales(entity.getTotalSales());
        response.setTotalTransactions(entity.getTotalTransactions());
        response.setAverageOrderValue(entity.getAverageOrderValue());
        response.setReportData(entity.getReportData());
        response.setGeneratedAt(entity.getGeneratedAt());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public SalesReports toEntity(SalesReportsRequest request) {
        if (request == null)
            return null;

        SalesReports entity = new SalesReports();

        entity.setReportType(request.getReportType());
        entity.setPeriod(request.getPeriod());
        entity.setTotalSales(request.getTotalSales());
        entity.setTotalTransactions(request.getTotalTransactions());
        entity.setAverageOrderValue(request.getAverageOrderValue());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(SalesReportsRequest request, SalesReports entity) {
        if (request == null || entity == null)
            return;

        entity.setReportType(request.getReportType());
        entity.setPeriod(request.getPeriod());
        entity.setTotalSales(request.getTotalSales());
        entity.setTotalTransactions(request.getTotalTransactions());
        entity.setAverageOrderValue(request.getAverageOrderValue());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<SalesReportsResponse> toResponseList(List<SalesReports> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
