package com.example.pos.Request.Products;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBatchExpiryRequest {
    private Long productId;
    @NotBlank(message = "Batch number is required")
    private String batchNumber;
    private LocalDate expiryDate;
    private LocalDate manufacturingDate;
    private Integer quantity;
    private String status;
}
