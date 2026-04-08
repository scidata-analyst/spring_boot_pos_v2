package com.example.pos.Request.Hardware;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQRMobilePayRequest {
    private String paymentMethod;
    private String qrCode;
    private String merchantId;
    private String status;
}
