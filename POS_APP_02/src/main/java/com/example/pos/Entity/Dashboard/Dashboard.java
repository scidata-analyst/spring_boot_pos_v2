package com.example.pos.Entity.Dashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "dashboard")
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double todayRevenue;
    private Integer transactions;
    private Integer customerToday;
    private Double avgBasketValue;
    private Integer returnToday;
    private Integer LoyaltyMembers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTodayRevenue() {
        return todayRevenue;
    }

    public void setTodayRevenue(Double todayRevenue) {
        this.todayRevenue = todayRevenue;
    }

    public Integer getTransactions() {
        return transactions;
    }

    public void setTransactions(Integer transactions) {
        this.transactions = transactions;
    }

    public Integer getCustomerToday() {
        return customerToday;
    }

    public void setCustomerToday(Integer customerToday) {
        this.customerToday = customerToday;
    }

    public Double getAvgBasketValue() {
        return avgBasketValue;
    }

    public void setAvgBasketValue(Double avgBasketValue) {
        this.avgBasketValue = avgBasketValue;
    }

    public Integer getReturnToday() {
        return returnToday;
    }

    public void setReturnToday(Integer returnToday) {
        this.returnToday = returnToday;
    }

    public Integer getLoyaltyMembers() {
        return LoyaltyMembers;
    }

    public void setLoyaltyMembers(Integer loyaltyMembers) {
        LoyaltyMembers = loyaltyMembers;
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
