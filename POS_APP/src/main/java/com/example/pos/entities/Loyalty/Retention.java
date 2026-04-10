package com.example.pos.entities.Loyalty;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity representing customer retention tracking.
 * Maps to the retention_tracking table in the database.
 */
@Entity
@Table(name = "retention_tracking")
public class Retention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "last_purchase_date")
    private LocalDate lastPurchaseDate;

    @Column(name = "days_since_last_purchase")
    private Integer daysSinceLastPurchase;

    @Column(name = "churn_risk", length = 50)
    private String churnRisk;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Retention() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public Integer getDaysSinceLastPurchase() {
        return daysSinceLastPurchase;
    }

    public void setDaysSinceLastPurchase(Integer daysSinceLastPurchase) {
        this.daysSinceLastPurchase = daysSinceLastPurchase;
    }

    public String getChurnRisk() {
        return churnRisk;
    }

    public void setChurnRisk(String churnRisk) {
        this.churnRisk = churnRisk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}