package com.scidata_analyst.pos.dto.sale;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private Long id;
    private String invoiceNumber;

    private Long customerId;
    private String customerName;

    private Long userId;
    private String cashierName;

    @NotEmpty(message = "Sale items are required")
    @Valid
    private List<SaleItemDTO> items;

    @NotNull(message = "Subtotal is required")
    private BigDecimal subtotal;

    @NotNull(message = "Tax is required")
    @DecimalMin(value = "0.0", message = "Tax cannot be negative")
    private BigDecimal tax;

    @DecimalMin(value = "0.0", message = "Discount cannot be negative")
    private BigDecimal discount;

    @NotNull(message = "Total is required")
    private BigDecimal total;

    @NotNull(message = "Amount paid is required")
    private BigDecimal amountPaid;

    private BigDecimal changeAmount;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    private String status;

    private String notes;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SaleItemDTO {
        private Long id;
        private Long productId;
        private String productName;
        private String barcode;
        private Integer quantity;
        private BigDecimal unitPrice;
        private BigDecimal discount;
        private BigDecimal total;
    }
}
