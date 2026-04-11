package com.example.pos.dtos.request.Suppliers;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: PurchaseOrders
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class PurchaseOrdersRequest {


    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * supplierId
     */
    @NotNull(message = "supplierId is required")
    private Long supplierId;

    /**
     * orderNumber
     */
    @NotBlank(message = "orderNumber is required")
    private String orderNumber;

    /**
     * totalAmount
     */
    @NotNull(message = "totalAmount is required")
    private Double totalAmount;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * orderDate
     */
    @NotNull(message = "orderDate is required")
    private LocalDateTime orderDate;

    /**
     * expectedDelivery
     */
    @NotNull(message = "expectedDelivery is required")
    private LocalDate expectedDelivery;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(LocalDate expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
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
