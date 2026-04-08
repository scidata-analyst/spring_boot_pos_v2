package com.example.pos.DTO.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementDTO {
    private Long id;
    private Long productId;
    private String type;
    private Integer quantity;
    private Long referenceId;
    private String reason;
    private LocalDateTime createdAt;
}
