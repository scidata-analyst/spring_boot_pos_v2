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
public class PLReportDTO {
    private Long id;
    private String reportType;
    private String period;
    private Double revenue;
    private Double costOfGoods;
    private Double grossProfit;
    private Double expenses;
    private Double netProfit;
    private String reportData;
    private LocalDateTime generatedAt;
    private LocalDateTime createdAt;
}
