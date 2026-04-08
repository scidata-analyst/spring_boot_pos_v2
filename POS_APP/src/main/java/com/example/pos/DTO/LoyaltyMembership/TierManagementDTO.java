package com.example.pos.DTO.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TierManagementDTO {
    private Long id;
    private String tierName;
    private Integer minPoints;
    private Integer maxPoints;
    private Double discountPercentage;
    private String benefits;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
