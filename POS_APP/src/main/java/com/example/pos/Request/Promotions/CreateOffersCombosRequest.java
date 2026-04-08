package com.example.pos.Request.Promotions;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOffersCombosRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Type is required")
    private String type;
    private Float discount;
    private Long productId;
    private String appliesTo;
    private String status;
    private Integer minQuantity;
    private String validPeriod;
    private Integer used;
    private Integer usageLimit;
}
