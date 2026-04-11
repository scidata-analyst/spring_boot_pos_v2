package com.example.pos.entities.PaymentAccounting;

import jakarta.persistence.*;
import java.time.LocalDateTime;


/**
 * =====================================================
 * Entity: Reconciliation
 * Table: reconciliation
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "reconciliation")
public class Reconciliation {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * registerId
     */

    private Long registerId;

    /**
     * expectedAmount
     */

    private Double expectedAmount;

    /**
     * actualAmount
     */

    private Double actualAmount;

    /**
     * variance
     */

    private Double variance;

    /**
     * notes
     */
    @Lob

    private String notes;

    /**
     * status
     */

    private String status;

    /**
     * reconciledAt
     */

    private LocalDateTime reconciledAt;

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
