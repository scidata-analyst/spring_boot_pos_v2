package com.example.pos.Entity.CustomersCRM;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Lob;

@Entity
@Table(name = "loyalty_points")
public class LoyaltyPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private double points;
    private LocalDate pointExpire;
    private LocalDate earnThisMonth;
    private Long redeem;
    private double deductAdd;

    @Lob
    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public LocalDate getPointExpire() {
        return pointExpire;
    }

    public void setPointExpire(LocalDate pointExpire) {
        this.pointExpire = pointExpire;
    }

    public LocalDate getEarnThisMonth() {
        return earnThisMonth;
    }

    public void setEarnThisMonth(LocalDate earnThisMonth) {
        this.earnThisMonth = earnThisMonth;
    }

    public Long getRedeem() {
        return redeem;
    }

    public void setRedeem(Long redeem) {
        this.redeem = redeem;
    }

    public double getDeductAdd() {
        return deductAdd;
    }

    public void setDeductAdd(double deductAdd) {
        this.deductAdd = deductAdd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
