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
public class CreateStockMovementRequest {
    private Long productId;
    @NotBlank(message = "Type is required")
    private String type;
    private Integer quantity;
    private Long referenceId;
    private String reason;
}
