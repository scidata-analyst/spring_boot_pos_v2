package com.example.pos.dtos.request.SalesBilling;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: Invoices
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class InvoicesRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * invoiceNumber
     */
    @NotBlank(message = "invoiceNumber is required")
    private String invoiceNumber;

    /**
     * transactionId
     */
    @NotNull(message = "transactionId is required")
    private Long transactionId;

    /**
     * customerId
     */
    @NotNull(message = "customerId is required")
    private Long customerId;

    /**
     * totalAmount
     */
    @NotNull(message = "totalAmount is required")
    private Double totalAmount;

    /**
     * amountPaid
     */
    @NotNull(message = "amountPaid is required")
    private Double amountPaid;

    /**
     * balanceDue
     */
    @NotNull(message = "balanceDue is required")
    private Double balanceDue;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * dueDate
     */
    @NotNull(message = "dueDate is required")
    private LocalDate dueDate;

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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(Double balanceDue) {
        this.balanceDue = balanceDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
