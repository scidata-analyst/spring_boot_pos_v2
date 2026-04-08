package com.example.pos.Request.Hardware;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQRMobilePayRequest {
    private String paymentMethod;
    private String qrCode;
    private String merchantId;
    private String status;
}
