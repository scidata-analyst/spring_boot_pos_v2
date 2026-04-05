package com.scidata_analyst.pos.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockResponse {

    private Long productId;
    private String productName;
    private String barcode;
    private Integer currentStock;
    private Integer reorderLevel;
    private Boolean isLowStock;
    private String lastUpdated;
}
