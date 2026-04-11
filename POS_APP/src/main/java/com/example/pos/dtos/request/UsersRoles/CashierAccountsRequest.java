package com.example.pos.dtos.request.UsersRoles;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: CashierAccounts
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class CashierAccountsRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * username
     */
    @NotBlank(message = "username is required")
    private String username;

    /**
     * password
     */
    @NotBlank(message = "password is required")
    private String password;

    /**
     * employeeName
     */
    @NotBlank(message = "employeeName is required")
    private String employeeName;

    /**
     * email
     */
    @NotBlank(message = "email is required")
    private String email;

    /**
     * phoneNumber
     */
    @NotNull(message = "phoneNumber is required")
    private Integer phoneNumber;

    /**
     * roleId
     */
    @NotNull(message = "roleId is required")
    private Long roleId;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * lastLogin
     */
    @NotNull(message = "lastLogin is required")
    private LocalDateTime lastLogin;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
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
