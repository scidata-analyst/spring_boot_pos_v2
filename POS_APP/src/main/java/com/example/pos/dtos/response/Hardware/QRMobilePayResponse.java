package com.example.pos.dtos.response.Hardware;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: QRMobilePay
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class QRMobilePayResponse {

    /**
     * id
     */
    private Long id;

    /**
     * paymentMethod
     */
    private String paymentMethod;

    /**
     * qrCode
     */
    private String qrCode;

    /**
     * merchantId
     */
    private String merchantId;

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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
