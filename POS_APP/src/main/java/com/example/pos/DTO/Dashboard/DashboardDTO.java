package com.example.pos.DTO.Dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {
    private Long id;
    private String widgetType;
    private String title;
    private String dataSource;
    private String configuration;
    private Integer position;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
