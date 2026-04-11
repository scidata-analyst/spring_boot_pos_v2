package com.example.pos.dtos.request.ReportsAnalytics;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: StockReports
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class StockReportsRequest {


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
     * totalProducts
     */
    @NotNull(message = "totalProducts is required")
    private Integer totalProducts;

    /**
     * lowStockItems
     */
    @NotNull(message = "lowStockItems is required")
    private Integer lowStockItems;

    /**
     * outOfStockItems
     */
    @NotNull(message = "outOfStockItems is required")
    private Integer outOfStockItems;

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
