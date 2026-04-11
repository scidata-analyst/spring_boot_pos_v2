package com.example.pos.dtos.request.CustomersCRM;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: CustomerDirectory
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class CustomerDirectoryRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * name
     */
    @NotBlank(message = "name is required")
    private String name;

    /**
     * email
     */
    @NotBlank(message = "email is required")
    private String email;

    /**
     * phoneNumber
     */
    @NotNull(message = "phoneNumber is required")
    private Integer phoneNumber;

    /**
     * loyaltyTier
     */
    @NotBlank(message = "loyaltyTier is required")
    private String loyaltyTier;

    /**
     * points
     */
    @NotNull(message = "points is required")
    private Float points;

    /**
     * totalSpent
     */
    @NotNull(message = "totalSpent is required")
    private Double totalSpent;

    /**
     * visits
     */
    @NotBlank(message = "visits is required")
    private String visits;

    /**
     * lastVisitDate
     */
    @NotBlank(message = "lastVisitDate is required")
    private String lastVisitDate;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * dateOfBirth
     */
    @NotNull(message = "dateOfBirth is required")
    private LocalDate dateOfBirth;

    /**
     * notes
     */
    @NotBlank(message = "notes is required")
    private String notes;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public void setLoyaltyTier(String loyaltyTier) {
        this.loyaltyTier = loyaltyTier;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
