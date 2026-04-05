package com.scidata_analyst.pos.dto.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockDTO {

    @NotNull(message = "Product ID is required")
    private Long productId;

    private String productName;
    private String barcode;

    @NotNull(message = "Current stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer currentStock;

    @Min(value = 0, message = "Reorder level cannot be negative")
    private Integer reorderLevel;

    private Boolean isLowStock;

    @DecimalMin(value = "0.0", message = "Cost price cannot be negative")
    private BigDecimal costPrice;

    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    private BigDecimal price;

    private BigDecimal stockValue;
}
