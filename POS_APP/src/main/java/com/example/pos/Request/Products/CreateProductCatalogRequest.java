package com.example.pos.Request.Products;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCatalogRequest {
    @NotBlank(message = "Name is required")
    private String name;
    private String sku;
    private Long barcodeId;
    private String categoryId;
    private Double price;
    private Double cost;
    private Integer stock;
    private String status;
    private String unit;
    private Double salePrice;
    private Double costPrice;
    private Integer stockQty;
    private Integer reorderLevel;
    private String taxRate;
}
