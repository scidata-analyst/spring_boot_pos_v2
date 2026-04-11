package com.example.pos.entities.ReportsAnalytics;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: PLReport
 * Table: pl_report
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "pl_report")
public class PLReport {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
     * revenue
     */

    private Double revenue;

    /**
     * costOfGoods
     */

    private Double costOfGoods;

    /**
     * grossProfit
     */

    private Double grossProfit;

    /**
     * expenses
     */

    private Double expenses;

    /**
     * netProfit
     */

    private Double netProfit;

    /**
     * reportData
     */
    @Lob

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
