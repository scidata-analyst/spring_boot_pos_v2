package com.example.pos.dtos.request.CustomersCRM;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: PurchaseHistory
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class PurchaseHistoryRequest {

    /**
     * id
     */
    private Long id;

    /**
     * customerId
     */
    @NotNull(message = "customerId is required")
    private Long customerId;

    /**
     * transactionId
     */
    @NotNull(message = "transactionId is required")
    private Long transactionId;

    /**
     * totalAmount
     */
    @NotNull(message = "totalAmount is required")
    private Double totalAmount;

    /**
     * items
     */
    @NotBlank(message = "items is required")
    private String items;

    /**
     * purchaseDate
     */
    @NotNull(message = "purchaseDate is required")
    private LocalDateTime purchaseDate;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
