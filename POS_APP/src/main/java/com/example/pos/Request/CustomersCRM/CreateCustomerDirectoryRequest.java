package com.example.pos.Request.CustomersCRM;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDirectoryRequest {
    @NotBlank(message = "Name is required")
    private String name;
    private String email;
    private String phoneNumber;
    private String loyaltyTier;
    private Float points;
    private Double totalSpent;
    private String visits;
    private String lastVisitDate;
    private String status;
    private LocalDate dateOfBirth;
    private String notes;
}
