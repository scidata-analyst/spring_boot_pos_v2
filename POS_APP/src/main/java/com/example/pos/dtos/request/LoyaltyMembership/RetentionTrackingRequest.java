package com.example.pos.dtos.request.LoyaltyMembership;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: RetentionTracking
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class RetentionTrackingRequest {

    /**
     * id
     */
    private Long id;

    /**
     * customerId
     */
    @NotNull(message = "customerId is required")
    private Long customerId;

    /**
     * lastPurchaseDate
     */
    @NotNull(message = "lastPurchaseDate is required")
    private LocalDate lastPurchaseDate;

    /**
     * daysSinceLastPurchase
     */
    @NotNull(message = "daysSinceLastPurchase is required")
    private Integer daysSinceLastPurchase;

    /**
     * churnRisk
     */
    @NotBlank(message = "churnRisk is required")
    private String churnRisk;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * createdAt
     */
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    private LocalDateTime updatedAt;

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
