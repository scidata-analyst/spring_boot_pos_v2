package com.example.pos.Request.ReportsAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSalesReportsRequest {
    private String reportType;
    private String period;
    private Double totalSales;
    private Integer totalTransactions;
    private Double averageOrderValue;
    private String reportData;
}
