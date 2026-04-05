package com.scidata_analyst.pos.dto.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventorySummaryDTO {

    private Long totalProducts;
    private Long activeProducts;
    private Long lowStockProducts;
    private Long outOfStockProducts;
    private Integer totalStockQuantity;
    private BigDecimal totalStockValue;
    private BigDecimal totalCostValue;
    private Double averageStockLevel;
    private Double inventoryTurnoverRate;
}
