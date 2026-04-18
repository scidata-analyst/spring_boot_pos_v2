package com.example.pos.dtos.request.Products;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: BatchExpiry
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class BatchExpiryRequest {

    /**
     * id
     */
    private Long id;

    /**
     * productId
     */
    @NotNull(message = "productId is required")
    private Long productId;

    /**
     * batchNumber
     */
    @NotBlank(message = "batchNumber is required")
    private String batchNumber;

    /**
     * expiryDate
     */
    @NotNull(message = "expiryDate is required")
    private LocalDate expiryDate;

    /**
     * manufacturingDate
     */
    @NotNull(message = "manufacturingDate is required")
    private LocalDate manufacturingDate;

    /**
     * quantity
     */
    @NotNull(message = "quantity is required")
    private Integer quantity;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
