package com.example.pos.entities.Products;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: StockMovement
 * Table: stock_movement
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "stock_movement")
public class StockMovement {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * productId
     */

    private Long productId;

    /**
     * type
     */

    private String type;

    /**
     * quantity
     */

    private Integer quantity;

    /**
     * referenceId
     */

    private Long referenceId;

    /**
     * reason
     */

    private String reason;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
