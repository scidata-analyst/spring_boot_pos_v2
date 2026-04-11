package com.example.pos.entities.CustomersCRM;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: PurchaseHistory
 * Table: purchase_history
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
    @Lob

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
