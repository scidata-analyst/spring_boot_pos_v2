package com.example.pos.dtos.response.Loyalty;

import java.util.List;

/**
 * Response DTO for PointsConfig
 */
public class PointsConfigResponse {

    private Long id;

    // TODO: Add other fields to return in API response
    // Example: private String name;
    // TODO: Add relationship fields as nested DTOs if required
    // Example: private List<ChildEntityResponse> children;

    public PointsConfigResponse() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // TODO: Add getters and setters for other fields
}
