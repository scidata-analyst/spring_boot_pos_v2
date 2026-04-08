package com.example.pos.entity.reports_analytics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_reports")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportType;

    private String period;

    private Double totalSales;

    private Integer totalTransactions;

    private Double averageOrderValue;

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
