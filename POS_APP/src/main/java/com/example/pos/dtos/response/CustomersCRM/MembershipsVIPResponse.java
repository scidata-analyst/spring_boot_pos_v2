package com.example.pos.dtos.response.CustomersCRM;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: MembershipsVIP
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class MembershipsVIPResponse {

    /**
     * id
     */
    private Long id;

    /**
     * customerId
     */
    private Long customerId;

    /**
     * membershipType
     */
    private String membershipType;

    /**
     * startDate
     */
    private LocalDate startDate;

    /**
     * endDate
     */
    private LocalDate endDate;

    /**
     * benefits
     */
    private String benefits;

    /**
     * status
     */
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
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
