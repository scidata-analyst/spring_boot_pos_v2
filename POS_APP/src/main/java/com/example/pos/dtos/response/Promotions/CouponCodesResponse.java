package com.example.pos.dtos.response.Promotions;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: CouponCodes
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class CouponCodesResponse {

    /**
     * id
     */
    private Long id;

    /**
     * code
     */
    private String code;

    /**
     * discountType
     */
    private String discountType;

    /**
     * discountValue
     */
    private Double discountValue;

    /**
     * minOrderAmount
     */
    private Double minOrderAmount;

    /**
     * maxUses
     */
    private Integer maxUses;

    /**
     * usedCount
     */
    private Integer usedCount;

    /**
     * validFrom
     */
    private LocalDateTime validFrom;

    /**
     * validUntil
     */
    private LocalDateTime validUntil;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(Double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(Integer maxUses) {
        this.maxUses = maxUses;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
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
