package com.example.pos.DTO.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetentionTrackingDTO {
    private Long id;
    private Long customerId;
    private LocalDate lastPurchaseDate;
    private Integer daysSinceLastPurchase;
    private String churnRisk;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
