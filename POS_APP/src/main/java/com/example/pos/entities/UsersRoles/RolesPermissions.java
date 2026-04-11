package com.example.pos.entities.UsersRoles;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: RolesPermissions
 * Table: roles_permissions
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "roles_permissions")
public class RolesPermissions {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * roleName
     */

    private String roleName;

    /**
     * permissions
     */

    private String permissions;

    /**
     * description
     */

    private String description;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
