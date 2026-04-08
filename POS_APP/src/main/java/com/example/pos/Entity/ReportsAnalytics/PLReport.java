package com.example.pos.entity.reports_analytics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "pl_report")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PLReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportType;

    private String period;

    private Double revenue;

    private Double costOfGoods;

    private Double grossProfit;

    private Double expenses;

    private Double netProfit;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String reportData;

    private LocalDateTime generatedAt;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
