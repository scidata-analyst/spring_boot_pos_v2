package com.scidata_analyst.pos.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierProductDTO {

    private Long supplierId;
    private String supplierName;
    private String contactPerson;
    private String phone;
    private Long totalProducts;
    private Long activeProducts;
    private BigDecimal totalStockValue;
    private BigDecimal averageCostPrice;
}
