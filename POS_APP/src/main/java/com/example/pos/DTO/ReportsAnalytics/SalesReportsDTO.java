package com.example.pos.DTO.ReportsAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesReportsDTO {
    private Long id;
    private String reportType;
    private String period;
    private Double totalSales;
    private Integer totalTransactions;
    private Double averageOrderValue;
    private String reportData;
    private LocalDateTime generatedAt;
    private LocalDateTime createdAt;
}
