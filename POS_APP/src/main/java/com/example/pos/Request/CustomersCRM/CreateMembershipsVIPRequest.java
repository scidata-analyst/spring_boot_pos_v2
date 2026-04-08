package com.example.pos.Request.CustomersCRM;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMembershipsVIPRequest {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String benefits;
    private String status;
}
