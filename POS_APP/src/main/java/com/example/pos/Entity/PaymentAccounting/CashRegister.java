package com.example.pos.entity.payment_accounting;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "cash_register")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String registerName;

    private Double openingBalance;

    private Double closingBalance;

    private Double cashIn;

    private Double cashOut;

    private String status;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
