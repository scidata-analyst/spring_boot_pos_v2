package com.example.pos.entities.Suppliers;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing restock alerts for low inventory.
 * Maps to the restock_alerts table in the database.
 */
@Entity
@Table(name = "restock_alerts")
public class RestockAlerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "alert_date")
    private LocalDateTime alertDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public RestockAlerts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}