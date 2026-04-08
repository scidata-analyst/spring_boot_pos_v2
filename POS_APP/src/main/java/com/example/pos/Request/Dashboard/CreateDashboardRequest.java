package com.example.pos.Request.Dashboard;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDashboardRequest {
    @NotBlank(message = "Widget type is required")
    private String widgetType;
    @NotBlank(message = "Title is required")
    private String title;
    private String dataSource;
    private String configuration;
    private Integer position;
    private String status;
}
