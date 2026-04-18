package com.example.pos.dtos.request.Hardware;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: CashDrawer
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class CashDrawerRequest {

    /**
     * id
     */
    private Long id;

    /**
     * drawerNumber
     */
    @NotBlank(message = "drawerNumber is required")
    private String drawerNumber;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * connectedDevice
     */
    @NotBlank(message = "connectedDevice is required")
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
