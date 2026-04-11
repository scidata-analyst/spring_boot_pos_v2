package com.example.pos.dtos.response.Hardware;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: CashDrawer
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class CashDrawerResponse {

    /**
     * id
     */
    private Long id;

    /**
     * drawerNumber
     */
    private String drawerNumber;

    /**
     * status
     */
    private String status;

    /**
     * connectedDevice
     */
    private String connectedDevice;

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

    public String getDrawerNumber() {
        return drawerNumber;
    }

    public void setDrawerNumber(String drawerNumber) {
        this.drawerNumber = drawerNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConnectedDevice() {
        return connectedDevice;
    }

    public void setConnectedDevice(String connectedDevice) {
        this.connectedDevice = connectedDevice;
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
