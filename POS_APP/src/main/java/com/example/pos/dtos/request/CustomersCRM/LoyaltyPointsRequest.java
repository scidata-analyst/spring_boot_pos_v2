package com.example.pos.dtos.request.CustomersCRM;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: LoyaltyPoints
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class LoyaltyPointsRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * customerId
     */
    @NotNull(message = "customerId is required")
    private Long customerId;

    /**
     * points
     */
    @NotNull(message = "points is required")
    private Integer points;

    /**
     * transactionId
     */
    @NotNull(message = "transactionId is required")
    private Long transactionId;

    /**
     * type
     */
    @NotBlank(message = "type is required")
    private String type;

    /**
     * expiryDate
     */
    @NotNull(message = "expiryDate is required")
    private LocalDate expiryDate;

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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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

}
