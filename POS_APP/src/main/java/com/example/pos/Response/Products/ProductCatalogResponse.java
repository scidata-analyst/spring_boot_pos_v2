package com.example.pos.Response.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogResponse {
    private Long id;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
