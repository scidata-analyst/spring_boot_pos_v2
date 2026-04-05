package com.scidata_analyst.pos.dto.inventory;

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
public class InventoryDTO {

    @NotNull(message = "Product ID is required")
    private Long productId;

    private String productName;
    private String barcode;

    @NotNull(message = "Current stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer currentStock;

    @Min(value = 0, message = "Reorder level cannot be negative")
    private Integer reorderLevel;

    private String categoryName;
    private String supplierName;

    private Boolean isLowStock;

    private Integer stockValue;
}
