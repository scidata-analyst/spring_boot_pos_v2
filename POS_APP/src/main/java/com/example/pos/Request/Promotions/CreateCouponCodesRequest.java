package com.example.pos.Request.Promotions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCouponCodesRequest {
    @NotBlank(message = "Code is required")
    private String code;
    @NotBlank(message = "Discount type is required")
    private String discountType;
    @NotNull(message = "Discount value is required")
    private Double discountValue;
    private Double minOrderAmount;
    private Integer maxUses;
    private Integer usedCount;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private String status;
}
