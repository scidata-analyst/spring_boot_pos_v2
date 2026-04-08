package com.example.pos.Request.LoyaltyMembership;

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
public class CreateRetentionTrackingRequest {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    private LocalDate lastPurchaseDate;
    private Integer daysSinceLastPurchase;
    private String churnRisk;
    private String status;
}
