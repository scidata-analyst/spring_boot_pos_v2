package com.scidata_analyst.pos.controller.sale;

import com.scidata_analyst.pos.dto.sale.SaleDTO;
import com.scidata_analyst.pos.dto.sale.SaleItemResponse;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.dto.sale.SalesReportDTO;
import com.scidata_analyst.pos.request.sale.CreateSaleRequest;
import com.scidata_analyst.pos.request.sale.ProcessPaymentRequest;
import com.scidata_analyst.pos.request.sale.SearchSaleRequest;
import com.scidata_analyst.pos.request.sale.UpdateSaleRequest;
import com.scidata_analyst.pos.response.sale.PaymentProcessResponse;
import com.scidata_analyst.pos.service.sale.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody CreateSaleRequest request) {
        SaleDTO created = saleService.createSale(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @Valid @RequestBody UpdateSaleRequest request) {
        SaleDTO updated = saleService.updateSale(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        SaleDTO sale = saleService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/invoice/{invoiceNumber}")
    public ResponseEntity<SaleDTO> getSaleByInvoiceNumber(@PathVariable String invoiceNumber) {
        SaleDTO sale = saleService.getSaleByInvoiceNumber(invoiceNumber);
        return ResponseEntity.ok(sale);
    }

    @GetMapping
    public ResponseEntity<Page<SaleSummaryDTO>> searchSales(SearchSaleRequest request) {
        Page<SaleSummaryDTO> sales = saleService.searchSales(request);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/recent")
    public ResponseEntity<List<SaleSummaryDTO>> getRecentSales(@RequestParam(defaultValue = "10") Integer limit) {
        List<SaleSummaryDTO> sales = saleService.getRecentSales(limit);
        return ResponseEntity.ok(sales);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentProcessResponse> processPayment(@Valid @RequestBody ProcessPaymentRequest request) {
        PaymentProcessResponse response = saleService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/report")
    public ResponseEntity<SalesReportDTO> getSalesReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        SalesReportDTO report = saleService.getSalesReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelSale(@PathVariable Long id, @RequestParam String reason) {
        saleService.cancelSale(id, reason);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<List<SaleItemResponse>> getSaleItems(@PathVariable Long id) {
        List<SaleItemResponse> items = saleService.getSaleItems(id);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<SaleItemResponse> addSaleItem(@PathVariable Long id, @Valid @RequestBody SaleItemRequest request) {
        SaleItemResponse item = saleService.addSaleItem(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}/items/{itemId}")
    public ResponseEntity<SaleItemResponse> updateSaleItem(@PathVariable Long id, @PathVariable Long itemId, @Valid @RequestBody SaleItemRequest request) {
        SaleItemResponse item = saleService.updateSaleItem(id, itemId, request);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}/items/{itemId}")
    public ResponseEntity<Void> removeSaleItem(@PathVariable Long id, @PathVariable Long itemId) {
        saleService.removeSaleItem(id, itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/customer")
    public ResponseEntity<Map<String, Object>> getSaleCustomer(@PathVariable Long id) {
        Map<String, Object> customer = saleService.getSaleCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/{id}/customer/{customerId}")
    public ResponseEntity<SaleDTO> assignSaleToCustomer(@PathVariable Long id, @PathVariable Long customerId) {
        SaleDTO updated = saleService.assignToCustomer(id, customerId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}/customer")
    public ResponseEntity<SaleDTO> removeSaleCustomer(@PathVariable Long id) {
        SaleDTO updated = saleService.removeCustomer(id);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}/payments")
    public ResponseEntity<List<Map<String, Object>>> getSalePayments(@PathVariable Long id) {
        List<Map<String, Object>> payments = saleService.getSalePayments(id);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> getSaleTotal(@PathVariable Long id) {
        BigDecimal total = saleService.getSaleTotal(id);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/daily-summary")
    public ResponseEntity<Map<String, Object>> getDailySalesSummary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Map<String, Object> summary = saleService.getDailySalesSummary(date);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SaleSummaryDTO>> getSalesByUser(@PathVariable Long userId) {
        List<SaleSummaryDTO> sales = saleService.getSalesByUser(userId);
        return ResponseEntity.ok(sales);
    }

    public static class SaleItemRequest {
        private Long productId;
        private Integer quantity;
        private BigDecimal unitPrice;
        private BigDecimal discount;

        public Long getProductId() { return productId; }
        public void setProductId(Long productId) { this.productId = productId; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public BigDecimal getUnitPrice() { return unitPrice; }
        public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
        public BigDecimal getDiscount() { return discount; }
        public void setDiscount(BigDecimal discount) { this.discount = discount; }
    }
}
