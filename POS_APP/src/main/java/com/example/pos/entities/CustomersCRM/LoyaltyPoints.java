package com.example.pos.entities.CustomersCRM;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * =====================================================
 * Entity: LoyaltyPoints
 * Table: loyalty_points
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "loyalty_points")
public class LoyaltyPoints {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * customerId
     */

    private Long customerId;

    /**
     * points
     */

    private Integer points;

    /**
     * transactionId
     */

    private Long transactionId;

    /**
     * type
     */

    private String type;

    /**
     * expiryDate
     */

    private LocalDate expiryDate;

    /**
     * status
     */

    private String status;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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


}
