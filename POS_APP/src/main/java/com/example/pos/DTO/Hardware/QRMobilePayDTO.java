package com.example.pos.DTO.Hardware;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QRMobilePayDTO {
    private Long id;
    private String paymentMethod;
    private String qrCode;
    private String merchantId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
