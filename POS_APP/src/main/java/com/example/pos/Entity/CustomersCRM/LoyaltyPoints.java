package com.example.pos.entity.customers_crm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "loyalty_points")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Integer points;

    private Long transactionId;

    @Column(nullable = false)
    private String type;

    private LocalDate expiryDate;

    private String status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
