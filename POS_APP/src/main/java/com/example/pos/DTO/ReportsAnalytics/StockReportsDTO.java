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
public class StockReportsDTO {
    private Long id;
    private String reportType;
    private Integer totalProducts;
    private Integer lowStockItems;
    private Integer outOfStockItems;
    private String reportData;
    private LocalDateTime generatedAt;
    private LocalDateTime createdAt;
}
