package com.example.pos.Request.PaymentAccounting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaxReportsRequest {
    @NotBlank(message = "Tax type is required")
    private String taxType;
    @NotNull(message = "Tax rate is required")
    private Double taxRate;
    @NotNull(message = "Taxable amount is required")
    private Double taxableAmount;
    @NotNull(message = "Tax amount is required")
    private Double taxAmount;
    private String period;
    private String status;
}
