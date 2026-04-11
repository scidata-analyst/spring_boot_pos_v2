package com.example.pos.dtos.response.UsersRoles;

import java.time.LocalDateTime;


/**
 * =====================================================
 * Response DTO: ActivityLog
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class ActivityLogResponse {


    /**
     * id
     */
    private Long id;

    /**
     * userId
     */
    private Long userId;

    /**
     * action
     */
    private String action;

    /**
     * module
     */
    private String module;

    /**
     * description
     */
    private String description;

    /**
     * ipAddress
     */
    private String ipAddress;

    /**
     * timestamp
     */
    private LocalDateTime timestamp;

    /**
     * createdAt
     */
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
