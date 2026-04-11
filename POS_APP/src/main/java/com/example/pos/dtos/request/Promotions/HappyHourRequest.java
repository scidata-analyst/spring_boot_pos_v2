package com.example.pos.dtos.request.Promotions;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: HappyHour
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class HappyHourRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * name
     */
    @NotBlank(message = "name is required")
    private String name;

    /**
     * startTime
     */
    @NotNull(message = "startTime is required")
    private LocalTime startTime;

    /**
     * endTime
     */
    @NotNull(message = "endTime is required")
    private LocalTime endTime;

    /**
     * daysOfWeek
     */
    @NotBlank(message = "daysOfWeek is required")
    private String daysOfWeek;

    /**
     * discountPercentage
     */
    @NotNull(message = "discountPercentage is required")
    private Double discountPercentage;

    /**
     * applicableProducts
     */
    @NotBlank(message = "applicableProducts is required")
    private String applicableProducts;

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
