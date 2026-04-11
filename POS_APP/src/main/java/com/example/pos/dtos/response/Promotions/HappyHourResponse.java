package com.example.pos.dtos.response.Promotions;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * =====================================================
 * Response DTO: HappyHour
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class HappyHourResponse {

    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * startTime
     */
    private LocalTime startTime;

    /**
     * endTime
     */
    private LocalTime endTime;

    /**
     * daysOfWeek
     */
    private String daysOfWeek;

    /**
     * discountPercentage
     */
    private Double discountPercentage;

    /**
     * applicableProducts
     */
    private String applicableProducts;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getApplicableProducts() {
        return applicableProducts;
    }

    public void setApplicableProducts(String applicableProducts) {
        this.applicableProducts = applicableProducts;
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
