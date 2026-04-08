package com.example.pos.Request.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBarcodeSKURequest {
    private String barcode;
    private String sku;
    private Long productId;
    private String variant;
    private String status;
}
