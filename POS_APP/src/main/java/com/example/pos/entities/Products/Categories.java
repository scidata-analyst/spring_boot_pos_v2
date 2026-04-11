package com.example.pos.entities.Products;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: Categories
 * Table: categories
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "categories")
public class Categories {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * name
     */

    private String name;

    /**
     * icon
     */

    private String icon;

    /**
     * status
     */

    private String status;

    /**
     * description
     */

    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
