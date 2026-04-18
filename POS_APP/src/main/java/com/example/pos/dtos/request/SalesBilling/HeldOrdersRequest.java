package com.example.pos.dtos.request.SalesBilling;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: HeldOrders
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class HeldOrdersRequest {

    /**
     * id
     */
    private Long id;

    /**
     * orderNumber
     */
    @NotBlank(message = "orderNumber is required")
    private String orderNumber;

    /**
     * cartData
     */
    @NotBlank(message = "cartData is required")
    private String cartData;

    /**
     * cashierId
     */
    @NotNull(message = "cashierId is required")
    private Long cashierId;

    /**
     * totalAmount
     */
    @NotNull(message = "totalAmount is required")
    private Double totalAmount;

    /**
     * holdDate
     */
    @NotNull(message = "holdDate is required")
    private LocalDateTime holdDate;

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
