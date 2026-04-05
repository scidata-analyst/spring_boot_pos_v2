package com.scidata_analyst.pos.response.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryAdjustResponse {

    private Long id;
    private Long productId;
    private String productName;
    private Integer previousStock;
    private Integer quantityChanged;
    private Integer currentStock;
    private String type;
    private String reference;
    private String notes;
    private String adjustedBy;
    private String adjustedAt;
}
