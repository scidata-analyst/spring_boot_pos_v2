package com.example.pos.dtos.response.ReportsAnalytics;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: StockReports
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class StockReportsResponse {

    /**
     * id
     */
    private Long id;

    /**
     * reportType
     */
    private String reportType;

    /**
     * totalProducts
     */
    private Integer totalProducts;

    /**
     * lowStockItems
     */
    private Integer lowStockItems;

    /**
     * outOfStockItems
     */
    private Integer outOfStockItems;

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

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Integer getLowStockItems() {
        return lowStockItems;
    }

    public void setLowStockItems(Integer lowStockItems) {
        this.lowStockItems = lowStockItems;
    }

    public Integer getOutOfStockItems() {
        return outOfStockItems;
    }

    public void setOutOfStockItems(Integer outOfStockItems) {
        this.outOfStockItems = outOfStockItems;
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
