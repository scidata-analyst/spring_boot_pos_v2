package com.example.pos.dtos.response.ReportsAnalytics;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: SalesReports
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class SalesReportsResponse {

    /**
     * id
     */
    private Long id;

    /**
     * reportType
     */
    private String reportType;

    /**
     * period
     */
    private String period;

    /**
     * totalSales
     */
    private Double totalSales;

    /**
     * totalTransactions
     */
    private Integer totalTransactions;

    /**
     * averageOrderValue
     */
    private Double averageOrderValue;

    /**
     * reportData
     */
    private String reportData;

    /**
     * generatedAt
     */
    private LocalDateTime generatedAt;

    /**
     * createdAt
     */
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
