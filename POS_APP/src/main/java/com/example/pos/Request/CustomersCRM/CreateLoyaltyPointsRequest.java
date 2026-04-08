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
public class CreateLoyaltyPointsRequest {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    @NotNull(message = "Points is required")
    private Integer points;
    private Long transactionId;
    @NotNull(message = "Type is required")
    private String type;
    private LocalDate expiryDate;
    private String status;
}
