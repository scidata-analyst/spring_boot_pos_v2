package com.example.pos.dtos.request.Promotions;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: CouponCodes
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class CouponCodesRequest {

    /**
     * id
     */
    private Long id;

    /**
     * code
     */
    @NotBlank(message = "code is required")
    private String code;

    /**
     * discountType
     */
    @NotBlank(message = "discountType is required")
    private String discountType;

    /**
     * discountValue
     */
    @NotNull(message = "discountValue is required")
    private Double discountValue;

    /**
     * minOrderAmount
     */
    @NotNull(message = "minOrderAmount is required")
    private Double minOrderAmount;

    /**
     * maxUses
     */
    @NotNull(message = "maxUses is required")
    private Integer maxUses;

    /**
     * usedCount
     */
    @NotNull(message = "usedCount is required")
    private Integer usedCount;

    /**
     * validFrom
     */
    @NotNull(message = "validFrom is required")
    private LocalDateTime validFrom;

    /**
     * validUntil
     */
    @NotNull(message = "validUntil is required")
    private LocalDateTime validUntil;

    /**
     * status
     */
    @NotBlank(message = "status is required")
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
