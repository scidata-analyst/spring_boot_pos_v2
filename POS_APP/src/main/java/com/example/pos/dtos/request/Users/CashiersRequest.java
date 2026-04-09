package com.example.pos.dtos.request.Users;

import jakarta.validation.constraints.*;

/**
 * Request DTO for Cashiers
 */
public class CashiersRequest {

    @NotNull(message = "Id cannot be null")
    private Long id;

    // TODO: Add other fields with validation annotations
    // Example: @NotBlank(message = "Name is required") private String name;

    public CashiersRequest() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // TODO: Add getters and setters for other fields
}
