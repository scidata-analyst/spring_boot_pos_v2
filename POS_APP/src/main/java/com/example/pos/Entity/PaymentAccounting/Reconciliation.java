package com.example.pos.entity.payment_accounting;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reconciliation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reconciliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long registerId;

    private Double expectedAmount;

    private Double actualAmount;

    private Double variance;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String notes;

    private String status;

    private LocalDateTime reconciledAt;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
