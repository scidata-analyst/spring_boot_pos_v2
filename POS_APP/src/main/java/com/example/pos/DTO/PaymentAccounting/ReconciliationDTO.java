package com.example.pos.DTO.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReconciliationDTO {
    private Long id;
    private Long registerId;
    private Double expectedAmount;
    private Double actualAmount;
    private Double variance;
    private String notes;
    private String status;
    private LocalDateTime reconciledAt;
    private LocalDateTime createdAt;
}
