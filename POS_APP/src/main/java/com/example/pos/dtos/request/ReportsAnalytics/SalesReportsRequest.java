package com.example.pos.dtos.request.ReportsAnalytics;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: SalesReports
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class SalesReportsRequest {

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
     * totalSales
     */
    @NotNull(message = "totalSales is required")
    private Double totalSales;

    /**
     * totalTransactions
     */
    @NotNull(message = "totalTransactions is required")
    private Integer totalTransactions;

    /**
     * averageOrderValue
     */
    @NotNull(message = "averageOrderValue is required")
    private Double averageOrderValue;

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

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Double getAverageOrderValue() {
        return averageOrderValue;
    }

    public void setAverageOrderValue(Double averageOrderValue) {
        this.averageOrderValue = averageOrderValue;
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
