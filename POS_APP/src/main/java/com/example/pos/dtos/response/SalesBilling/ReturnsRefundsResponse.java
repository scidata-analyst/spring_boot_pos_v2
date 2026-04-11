package com.example.pos.dtos.response.SalesBilling;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: ReturnsRefunds
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class ReturnsRefundsResponse {

    /**
     * id
     */
    private Long id;

    /**
     * transactionId
     */
    private Long transactionId;

    /**
     * productId
     */
    private Long productId;

    /**
     * quantity
     */
    private Integer quantity;

    /**
     * refundAmount
     */
    private Double refundAmount;

    /**
     * reason
     */
    private String reason;

    /**
     * status
     */
    private String status;

    /**
     * returnDate
     */
    private LocalDateTime returnDate;

    /**
     * createdAt
     */
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
