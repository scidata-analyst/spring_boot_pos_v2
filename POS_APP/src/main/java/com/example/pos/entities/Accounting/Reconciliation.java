package com.example.pos.entities.Accounting;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing cash register reconciliation records.
 * Maps to the reconciliation table in the database.
 */
@Entity
@Table(name = "reconciliation")
public class Reconciliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "register_id")
    private Long registerId;

    @Column(name = "expected_amount")
    private Double expectedAmount;

    @Column(name = "actual_amount")
    private Double actualAmount;

    @Column(name = "variance")
    private Double variance;

    @Lob
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "reconciled_at")
    private LocalDateTime reconciledAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Reconciliation() {
    }

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