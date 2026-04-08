package com.example.pos.Response.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchExpiryResponse {
    private Long id;
    private Long productId;
    private String batchNumber;
    private LocalDate expiryDate;
    private LocalDate manufacturingDate;
    private Integer quantity;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
