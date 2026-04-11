package com.example.pos.entities.LoyaltyMembership;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: PointsConfig
 * Table: points_config
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "points_config")
public class PointsConfig {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * pointsPerDollar
     */

    private Double pointsPerDollar;

    /**
     * redemptionRate
     */

    private Double redemptionRate;

    /**
     * minimumRedemption
     */

    private Integer minimumRedemption;

    /**
     * status
     */

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
