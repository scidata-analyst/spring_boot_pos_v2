package com.example.pos.entities.CustomersCRM;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * =====================================================
 * Entity: CustomerDirectory
 * Table: customer_directory
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "customer_directory")
public class CustomerDirectory {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * name
     */

    private String name;

    /**
     * email
     */

    private String email;

    /**
     * phoneNumber
     */

    private Integer phoneNumber;

    /**
     * loyaltyTier
     */

    private String loyaltyTier;

    /**
     * points
     */

    private Float points;

    /**
     * totalSpent
     */

    private Double totalSpent;

    /**
     * visits
     */

    private String visits;

    /**
     * lastVisitDate
     */

    private String lastVisitDate;

    /**
     * status
     */

    private String status;

    /**
     * dateOfBirth
     */

    private LocalDate dateOfBirth;

    /**
     * notes
     */
    @Lob

    private String notes;

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
