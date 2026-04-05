package com.scidata_analyst.pos.dto.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogDTO {

    private Long id;
    private Long productId;
    private String productName;
    private String barcode;
    private Integer quantityChange;
    private Integer quantityBefore;
    private Integer quantityAfter;
    private String type;
    private String reference;
    private String notes;
    private String adjustedBy;
    private LocalDateTime createdAt;
}
