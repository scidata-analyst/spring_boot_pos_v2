package com.example.pos.Entity.LoyaltyMembership;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_management")
public class TierManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tierName;
    private String pointThreshold;
    private String minPoints;
    private String maxPoints;
    private String pointPer;
    private String discount;
    private String feeShipping;
    private String BirthdayBonus;
    private String prioritySupport;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getPointThreshold() {
        return pointThreshold;
    }

    public void setPointThreshold(String pointThreshold) {
        this.pointThreshold = pointThreshold;
    }

    public String getMinPoints() {
        return minPoints;
    }

    public void setMinPoints(String minPoints) {
        this.minPoints = minPoints;
    }

    public String getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getPointPer() {
        return pointPer;
    }

    public void setPointPer(String pointPer) {
        this.pointPer = pointPer;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFeeShipping() {
        return feeShipping;
    }

    public void setFeeShipping(String feeShipping) {
        this.feeShipping = feeShipping;
    }

    public String getBirthdayBonus() {
        return BirthdayBonus;
    }

    public void setBirthdayBonus(String birthdayBonus) {
        BirthdayBonus = birthdayBonus;
    }

    public String getPrioritySupport() {
        return prioritySupport;
    }

    public void setPrioritySupport(String prioritySupport) {
        this.prioritySupport = prioritySupport;
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
