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
public class OffersCombosDTO {
    private Long id;
    private String name;
    private String type;
    private Float discount;
    private Long productId;
    private String appliesTo;
    private String status;
    private Integer minQuantity;
    private String validPeriod;
    private Integer used;
    private Integer usageLimit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
