package com.example.pos.dtos.request.Suppliers;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: SupplierPayments
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class SupplierPaymentsRequest {

    /**
     * id
     */
    private Long id;

    /**
     * supplierId
     */
    @NotNull(message = "supplierId is required")
    private Long supplierId;

    /**
     * amount
     */
    @NotNull(message = "amount is required")
    private Double amount;

    /**
     * paymentMethod
     */
    @NotBlank(message = "paymentMethod is required")
    private String paymentMethod;

    /**
     * referenceNumber
     */
    @NotBlank(message = "referenceNumber is required")
    private String referenceNumber;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * paymentDate
     */
    @NotNull(message = "paymentDate is required")
    private LocalDateTime paymentDate;

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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
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
