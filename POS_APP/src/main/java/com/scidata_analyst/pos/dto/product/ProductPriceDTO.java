package com.scidata_analyst.pos.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceDTO {

    private Long id;
    private String barcode;
    private String name;
    private BigDecimal costPrice;
    private BigDecimal price;
    private BigDecimal margin;
    private Double marginPercentage;
}
