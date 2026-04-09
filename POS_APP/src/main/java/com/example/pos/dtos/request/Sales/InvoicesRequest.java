package com.example.pos.dtos.request.Sales;

import jakarta.validation.constraints.*;

/**
 * Request DTO for Invoices
 */
public class InvoicesRequest {

    @NotNull(message = "Id cannot be null")
    private Long id;

    // TODO: Add other fields with validation annotations
    // Example: @NotBlank(message = "Name is required") private String name;

    public InvoicesRequest() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // TODO: Add getters and setters for other fields
}
