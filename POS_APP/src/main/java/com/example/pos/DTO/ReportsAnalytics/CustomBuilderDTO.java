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
public class CustomBuilderDTO {
    private Long id;
    private String reportName;
    private String queryConfig;
    private String chartType;
    private String filters;
    private Long createdBy;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
