package com.example.pos.entities.Sales;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing held orders for later retrieval.
 * Maps to the held_orders table in the database.
 */
@Entity
@Table(name = "held_orders")
public class HeldOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_number", length = 100, unique = true)
    private String orderNumber;

    @Lob
    @Column(name = "cart_data", columnDefinition = "TEXT")
    private String cartData;

    @Column(name = "cashier_id")
    private Long cashierId;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "hold_date")
    private LocalDateTime holdDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public HeldOrders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCartData() {
        return cartData;
    }

    public void setCartData(String cartData) {
        this.cartData = cartData;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(LocalDateTime holdDate) {
        this.holdDate = holdDate;
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