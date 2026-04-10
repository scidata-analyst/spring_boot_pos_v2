package com.example.pos.entities.Reports;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing stock reports.
 * Maps to the stock_reports table in the database.
 */
@Entity
@Table(name = "stock_reports")
public class StockReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_type", length = 50)
    private String reportType;

    @Column(name = "total_products")
    private Integer totalProducts;

    @Column(name = "low_stock_items")
    private Integer lowStockItems;

    @Column(name = "out_of_stock_items")
    private Integer outOfStockItems;

    @Lob
    @Column(name = "report_data", columnDefinition = "TEXT")
    private String reportData;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public StockReport() {
    }

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