package com.example.pos.mappers.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.PLReport;
import com.example.pos.dtos.request.ReportsAnalytics.PLReportRequest;
import com.example.pos.dtos.response.ReportsAnalytics.PLReportResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PLReportMapper {

    public PLReportResponse toResponse(PLReport entity) {
        if (entity == null)
            return null;

        PLReportResponse response = new PLReportResponse();

        response.setId(entity.getId());
        response.setReportType(entity.getReportType());
        response.setPeriod(entity.getPeriod());
        response.setRevenue(entity.getRevenue());
        response.setCostOfGoods(entity.getCostOfGoods());
        response.setGrossProfit(entity.getGrossProfit());
        response.setExpenses(entity.getExpenses());
        response.setNetProfit(entity.getNetProfit());
        response.setReportData(entity.getReportData());
        response.setGeneratedAt(entity.getGeneratedAt());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    public PLReport toEntity(PLReportRequest request) {
        if (request == null)
            return null;

        PLReport entity = new PLReport();

        entity.setReportType(request.getReportType());
        entity.setPeriod(request.getPeriod());
        entity.setRevenue(request.getRevenue());
        entity.setCostOfGoods(request.getCostOfGoods());
        entity.setGrossProfit(request.getGrossProfit());
        entity.setExpenses(request.getExpenses());
        entity.setNetProfit(request.getNetProfit());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public void updateEntity(PLReportRequest request, PLReport entity) {
        if (request == null || entity == null)
            return;

        entity.setReportType(request.getReportType());
        entity.setPeriod(request.getPeriod());
        entity.setRevenue(request.getRevenue());
        entity.setCostOfGoods(request.getCostOfGoods());
        entity.setGrossProfit(request.getGrossProfit());
        entity.setExpenses(request.getExpenses());
        entity.setNetProfit(request.getNetProfit());
        entity.setReportData(request.getReportData());
        entity.setGeneratedAt(request.getGeneratedAt());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public List<PLReportResponse> toResponseList(List<PLReport> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
