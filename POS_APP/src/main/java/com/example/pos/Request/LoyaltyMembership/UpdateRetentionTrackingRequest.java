package com.example.pos.Request.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRetentionTrackingRequest {
    private Long customerId;
    private LocalDate lastPurchaseDate;
    private Integer daysSinceLastPurchase;
    private String churnRisk;
    private String status;
}
