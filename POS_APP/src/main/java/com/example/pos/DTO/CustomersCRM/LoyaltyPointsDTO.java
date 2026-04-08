package com.example.pos.DTO.CustomersCRM;

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
public class LoyaltyPointsDTO {
    private Long id;
    private Long customerId;
    private Integer points;
    private Long transactionId;
    private String type;
    private LocalDate expiryDate;
    private String status;
    private LocalDateTime createdAt;
}
