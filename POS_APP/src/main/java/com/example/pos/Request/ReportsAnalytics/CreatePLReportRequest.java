package com.example.pos.Request.ReportsAnalytics;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePLReportRequest {
    @NotBlank(message = "Report type is required")
    private String reportType;
    private String period;
    private Double revenue;
    private Double costOfGoods;
    private Double grossProfit;
    private Double expenses;
    private Double netProfit;
    private String reportData;
}
