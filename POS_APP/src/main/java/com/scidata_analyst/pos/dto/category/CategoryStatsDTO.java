package com.scidata_analyst.pos.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryStatsDTO {

    private Long id;
    private String name;
    private Long totalProducts;
    private Long activeProducts;
    private Long lowStockProducts;
    private BigDecimal totalStockValue;
    private BigDecimal averagePrice;
}
