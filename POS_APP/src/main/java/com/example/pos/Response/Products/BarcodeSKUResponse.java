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
public class BarcodeSKUResponse {
    private Long id;
    private String barcode;
    private String sku;
    private Long productId;
    private String variant;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
