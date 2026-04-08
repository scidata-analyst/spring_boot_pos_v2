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
public class CreateStockReportsRequest {
    @NotBlank(message = "Report type is required")
    private String reportType;
    private Integer totalProducts;
    private Integer lowStockItems;
    private Integer outOfStockItems;
    private String reportData;
}
