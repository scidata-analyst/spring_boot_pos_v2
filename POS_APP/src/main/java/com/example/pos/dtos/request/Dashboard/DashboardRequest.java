package com.example.pos.dtos.request.Dashboard;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: Dashboard
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class DashboardRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * widgetType
     */
    @NotBlank(message = "widgetType is required")
    private String widgetType;

    /**
     * title
     */
    @NotBlank(message = "title is required")
    private String title;

    /**
     * dataSource
     */
    @NotBlank(message = "dataSource is required")
    private String dataSource;

    /**
     * configuration
     */
    @NotBlank(message = "configuration is required")
    private String configuration;

    /**
     * position
     */
    @NotNull(message = "position is required")
    private Integer position;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
