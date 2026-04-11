package com.example.pos.dtos.request.UsersRoles;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: ActivityLog
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class ActivityLogRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * userId
     */
    @NotNull(message = "userId is required")
    private Long userId;

    /**
     * action
     */
    @NotBlank(message = "action is required")
    private String action;

    /**
     * module
     */
    @NotBlank(message = "module is required")
    private String module;

    /**
     * description
     */
    @NotBlank(message = "description is required")
    private String description;

    /**
     * ipAddress
     */
    @NotBlank(message = "ipAddress is required")
    private String ipAddress;

    /**
     * timestamp
     */
    @NotNull(message = "timestamp is required")
    private LocalDateTime timestamp;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
