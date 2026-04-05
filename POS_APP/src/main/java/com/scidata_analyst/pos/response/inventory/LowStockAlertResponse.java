package com.scidata_analyst.pos.response.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LowStockAlertResponse {

    private Long productId;
    private String productName;
    private String barcode;
    private Integer currentStock;
    private Integer reorderLevel;
    private Integer stockDifference;
    private String categoryName;
    private String supplierName;
}
