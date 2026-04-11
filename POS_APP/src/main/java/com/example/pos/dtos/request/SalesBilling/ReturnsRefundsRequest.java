package com.example.pos.dtos.request.SalesBilling;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: ReturnsRefunds
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class ReturnsRefundsRequest {


    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * transactionId
     */
    @NotNull(message = "transactionId is required")
    private Long transactionId;

    /**
     * productId
     */
    @NotNull(message = "productId is required")
    private Long productId;

    /**
     * quantity
     */
    @NotNull(message = "quantity is required")
    private Integer quantity;

    /**
     * refundAmount
     */
    @NotNull(message = "refundAmount is required")
    private Double refundAmount;

    /**
     * reason
     */
    @NotBlank(message = "reason is required")
    private String reason;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * returnDate
     */
    @NotNull(message = "returnDate is required")
    private LocalDateTime returnDate;

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

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
