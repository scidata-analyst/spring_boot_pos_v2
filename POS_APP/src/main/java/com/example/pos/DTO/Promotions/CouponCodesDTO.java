package com.example.pos.DTO.Promotions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponCodesDTO {
    private Long id;
    private String code;
    private String discountType;
    private Double discountValue;
    private Double minOrderAmount;
    private Integer maxUses;
    private Integer usedCount;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
