package com.example.pos.Request.CustomersCRM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDirectoryRequest {
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
