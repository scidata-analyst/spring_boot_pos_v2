package com.example.pos.dtos.request.ReportsAnalytics;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: PLReport
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class PLReportRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * reportType
     */
    @NotBlank(message = "reportType is required")
    private String reportType;

    /**
     * period
     */
    @NotBlank(message = "period is required")
    private String period;

    /**
     * revenue
     */
    @NotNull(message = "revenue is required")
    private Double revenue;

    /**
     * costOfGoods
     */
    @NotNull(message = "costOfGoods is required")
    private Double costOfGoods;

    /**
     * grossProfit
     */
    @NotNull(message = "grossProfit is required")
    private Double grossProfit;

    /**
     * expenses
     */
    @NotNull(message = "expenses is required")
    private Double expenses;

    /**
     * netProfit
     */
    @NotNull(message = "netProfit is required")
    private Double netProfit;

    /**
     * reportData
     */
    @NotBlank(message = "reportData is required")
    private String reportData;

    /**
     * generatedAt
     */
    @NotNull(message = "generatedAt is required")
    private LocalDateTime generatedAt;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getCostOfGoods() {
        return costOfGoods;
    }

    public void setCostOfGoods(Double costOfGoods) {
        this.costOfGoods = costOfGoods;
    }

    public Double getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
