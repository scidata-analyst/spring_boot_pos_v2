package com.example.pos.dtos.response.CustomersCRM;

import java.time.LocalDateTime;


/**
 * =====================================================
 * Response DTO: PurchaseHistory
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class PurchaseHistoryResponse {


    /**
     * id
     */
    private Long id;

    /**
     * customerId
     */
    private Long customerId;

    /**
     * transactionId
     */
    private Long transactionId;

    /**
     * totalAmount
     */
    private Double totalAmount;

    /**
     * items
     */
    private String items;

    /**
     * purchaseDate
     */
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
