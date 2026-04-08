package com.example.pos.entity.sales_billing;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "returns_refunds")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnsRefunds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionId;

    private Long productId;

    private Integer quantity;

    private Double refundAmount;

    private String reason;

    private String status;

    private LocalDateTime returnDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
