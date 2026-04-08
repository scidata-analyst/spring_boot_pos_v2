package com.example.pos.Request.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaxReportsRequest {
    private String taxType;
    private Double taxRate;
    private Double taxableAmount;
    private Double taxAmount;
    private String period;
    private String status;
}
