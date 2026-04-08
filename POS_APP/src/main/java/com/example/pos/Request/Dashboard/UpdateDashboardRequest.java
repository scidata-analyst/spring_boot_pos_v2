package com.example.pos.Request.Dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDashboardRequest {
    private String widgetType;
    private String title;
    private String dataSource;
    private String configuration;
    private Integer position;
    private String status;
}
