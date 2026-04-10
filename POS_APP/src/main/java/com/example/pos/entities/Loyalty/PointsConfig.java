package com.example.pos.entities.Loyalty;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing loyalty points configuration.
 * Maps to the points_config table in the database.
 */
@Entity
@Table(name = "points_config")
public class PointsConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "points_per_dollar")
    private Double pointsPerDollar;

    @Column(name = "redemption_rate")
    private Double redemptionRate;

    @Column(name = "minimum_redemption")
    private Integer minimumRedemption;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public PointsConfig() {
    }

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