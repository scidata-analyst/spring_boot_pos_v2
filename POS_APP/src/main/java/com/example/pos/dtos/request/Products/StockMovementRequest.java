package com.example.pos.dtos.request.Products;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: StockMovement
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class StockMovementRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * productId
     */
    @NotNull(message = "productId is required")
    private Long productId;

    /**
     * type
     */
    @NotBlank(message = "type is required")
    private String type;

    /**
     * quantity
     */
    @NotNull(message = "quantity is required")
    private Integer quantity;

    /**
     * referenceId
     */
    @NotNull(message = "referenceId is required")
    private Long referenceId;

    /**
     * reason
     */
    @NotBlank(message = "reason is required")
    private String reason;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
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

}
