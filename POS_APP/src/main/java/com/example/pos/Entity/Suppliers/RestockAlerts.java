package com.example.pos.entity.suppliers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "restock_alerts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestockAlerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer currentStock;

    private Integer reorderLevel;

    private String status;

    private LocalDateTime alertDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
