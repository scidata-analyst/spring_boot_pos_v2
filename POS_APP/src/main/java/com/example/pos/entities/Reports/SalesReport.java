package com.example.pos.entities.Reports;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing sales reports.
 * Maps to the sales_reports table in the database.
 */
@Entity
@Table(name = "sales_reports")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_type", length = 50)
    private String reportType;

    @Column(name = "period", length = 50)
    private String period;

    @Column(name = "total_sales")
    private Double totalSales;

    @Column(name = "total_transactions")
    private Integer totalTransactions;

    @Column(name = "average_order_value")
    private Double averageOrderValue;

    @Lob
    @Column(name = "report_data", columnDefinition = "TEXT")
    private String reportData;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public SalesReport() {
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