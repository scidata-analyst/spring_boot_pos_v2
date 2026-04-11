package com.example.pos.entities.Suppliers;

import jakarta.persistence.*;
import java.time.LocalDateTime;


/**
 * =====================================================
 * Entity: RestockAlerts
 * Table: restock_alerts
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "restock_alerts")
public class RestockAlerts {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * productId
     */

    private Long productId;

    /**
     * currentStock
     */

    private Integer currentStock;

    /**
     * reorderLevel
     */

    private Integer reorderLevel;

    /**
     * status
     */

    private String status;

    /**
     * alertDate
     */

    private LocalDateTime alertDate;

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
