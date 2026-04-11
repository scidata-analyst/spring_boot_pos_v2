package com.example.pos.dtos.request.PaymentAccounting;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: Reconciliation
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class ReconciliationRequest {


    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * registerId
     */
    @NotNull(message = "registerId is required")
    private Long registerId;

    /**
     * expectedAmount
     */
    @NotNull(message = "expectedAmount is required")
    private Double expectedAmount;

    /**
     * actualAmount
     */
    @NotNull(message = "actualAmount is required")
    private Double actualAmount;

    /**
     * variance
     */
    @NotNull(message = "variance is required")
    private Double variance;

    /**
     * notes
     */
    @NotBlank(message = "notes is required")
    private String notes;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * reconciledAt
     */
    @NotNull(message = "reconciledAt is required")
    private LocalDateTime reconciledAt;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Double getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(Double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReconciledAt() {
        return reconciledAt;
    }

    public void setReconciledAt(LocalDateTime reconciledAt) {
        this.reconciledAt = reconciledAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
