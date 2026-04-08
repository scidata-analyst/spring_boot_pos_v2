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
public class CreateCustomBuilderRequest {
    @NotBlank(message = "Report name is required")
    private String reportName;
    private String queryConfig;
    private String chartType;
    private String filters;
    private Long createdBy;
    private String status;
}
