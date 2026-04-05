package com.scidata_analyst.pos.request.inventory;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustInventoryRequest {

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Quantity change is required")
    private Integer quantityChange;

    @NotNull(message = "Adjustment type is required")
    private AdjustmentType type;

    private String reference;

    private String notes;

    public enum AdjustmentType {
        RECEIVE, RETURN, DAMAGE, ADJUSTMENT, STOCK_TAKE
    }
}
