package com.example.pos.dtos.request.LoyaltyMembership;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: PointsConfig
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class PointsConfigRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * pointsPerDollar
     */
    @NotNull(message = "pointsPerDollar is required")
    private Double pointsPerDollar;

    /**
     * redemptionRate
     */
    @NotNull(message = "redemptionRate is required")
    private Double redemptionRate;

    /**
     * minimumRedemption
     */
    @NotNull(message = "minimumRedemption is required")
    private Integer minimumRedemption;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPointsPerDollar() {
        return pointsPerDollar;
    }

    public void setPointsPerDollar(Double pointsPerDollar) {
        this.pointsPerDollar = pointsPerDollar;
    }

    public Double getRedemptionRate() {
        return redemptionRate;
    }

    public void setRedemptionRate(Double redemptionRate) {
        this.redemptionRate = redemptionRate;
    }

    public Integer getMinimumRedemption() {
        return minimumRedemption;
    }

    public void setMinimumRedemption(Integer minimumRedemption) {
        this.minimumRedemption = minimumRedemption;
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
