package com.example.pos.dtos.request.Accounting;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * Request DTO for Accounts Payable / Accounts Receivable (APAR).
 *
 * This DTO is used for validating incoming API request data
 * before mapping to the ApAr entity.
 *
 * Notes:
 * - ID is optional for create, required for update (handle via groups if
 * needed)
 * - Business rules enforced using validation annotations
 *
 * @author POS Application
 * @version 1.0
 * @since 2024
 */
public class ApArRequest {

    /**
     * Unique identifier (Required for update operations)
     */
    private Long id;

    /**
     * Type of transaction: PAYABLE or RECEIVABLE
     */
    @NotBlank(message = "Type is required")
    @Size(max = 20, message = "Type must not exceed 20 characters")
    private String type;

    /**
     * Reference ID (e.g., invoice ID)
     */
    @Positive(message = "Reference ID must be a positive number")
    private Long referenceId;

    /**
     * Customer ID (Required for RECEIVABLE)
     */
    @Positive(message = "Customer ID must be a positive number")
    private Long customerId;

    /**
     * Supplier ID (Required for PAYABLE)
     */
    @Positive(message = "Supplier ID must be a positive number")
    private Long supplierId;

    /**
     * Transaction amount
     */
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    /**
     * Due date of payment/collection
     */
    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;

    /**
     * Status of transaction (e.g., PENDING, PAID, OVERDUE)
     */
    @NotBlank(message = "Status is required")
    @Size(max = 20, message = "Status must not exceed 20 characters")
    private String status;

    // ============================
    // Constructors
    // ============================

    public ApArRequest() {
    }

    // ============================
    // Getters and Setters
    // ============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}