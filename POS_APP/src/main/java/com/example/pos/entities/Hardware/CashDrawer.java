package com.example.pos.entities.Hardware;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing cash drawer hardware devices.
 * Maps to the cash_drawer table in the database.
 */
@Entity
@Table(name = "cash_drawer")
public class CashDrawer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "drawer_number", length = 50)
    private String drawerNumber;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "connected_device", length = 100)
    private String connectedDevice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CashDrawer() {
    }

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