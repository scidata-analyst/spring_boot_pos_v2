package com.example.pos.DTO.Products;

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
public class BatchExpiryDTO {
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
