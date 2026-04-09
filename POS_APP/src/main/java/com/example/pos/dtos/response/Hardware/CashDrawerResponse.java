package com.example.pos.dtos.response.Hardware;

import java.util.List;

/**
 * Response DTO for CashDrawer
 */
public class CashDrawerResponse {

    private Long id;

    // TODO: Add other fields to return in API response
    // Example: private String name;
    // TODO: Add relationship fields as nested DTOs if required
    // Example: private List<ChildEntityResponse> children;

    public CashDrawerResponse() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // TODO: Add getters and setters for other fields
}
