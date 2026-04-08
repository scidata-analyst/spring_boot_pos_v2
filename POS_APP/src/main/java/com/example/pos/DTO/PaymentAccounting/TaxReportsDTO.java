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
public class TaxReportsDTO {
    private Long id;
    private String taxType;
    private Double taxRate;
    private Double taxableAmount;
    private Double taxAmount;
    private String period;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
