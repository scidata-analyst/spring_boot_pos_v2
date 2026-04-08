package com.example.pos.Request.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReconciliationRequest {
    private Long registerId;
    private Double expectedAmount;
    private Double actualAmount;
    private Double variance;
    private String notes;
    private String status;
    private LocalDateTime reconciledAt;
}
