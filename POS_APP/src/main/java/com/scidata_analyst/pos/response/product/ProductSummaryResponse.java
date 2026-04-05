package com.scidata_analyst.pos.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummaryResponse {

    private Long id;
    private String barcode;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private Boolean isActive;
}
