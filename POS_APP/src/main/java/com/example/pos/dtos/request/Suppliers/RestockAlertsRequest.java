package com.example.pos.dtos.request.Suppliers;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: RestockAlerts
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class RestockAlertsRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * productId
     */
    @NotNull(message = "productId is required")
    private Long productId;

    /**
     * currentStock
     */
    @NotNull(message = "currentStock is required")
    private Integer currentStock;

    /**
     * reorderLevel
     */
    @NotNull(message = "reorderLevel is required")
    private Integer reorderLevel;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * alertDate
     */
    @NotNull(message = "alertDate is required")
    private LocalDateTime alertDate;

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
