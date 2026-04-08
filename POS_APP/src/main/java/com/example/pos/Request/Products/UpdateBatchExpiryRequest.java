package com.example.pos.Request.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBatchExpiryRequest {
    private Long productId;
    private String batchNumber;
    private LocalDate expiryDate;
    private LocalDate manufacturingDate;
    private Integer quantity;
    private String status;
}
