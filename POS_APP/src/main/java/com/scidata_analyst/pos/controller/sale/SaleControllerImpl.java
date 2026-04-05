package com.scidata_analyst.pos.controller.sale;

import com.scidata_analyst.pos.dto.sale.SaleDTO;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleControllerImpl implements SaleController {

    private final SaleService saleService;

    @Override
    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody CreateSaleRequest request) {
        SaleDTO created = saleService.createSale(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @Valid @RequestBody UpdateSaleRequest request) {
        SaleDTO updated = saleService.updateSale(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        SaleDTO sale = saleService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @Override
    @GetMapping("/invoice/{invoiceNumber}")
    public ResponseEntity<SaleDTO> getSaleByInvoiceNumber(@PathVariable String invoiceNumber) {
        SaleDTO sale = saleService.getSaleByInvoiceNumber(invoiceNumber);
        return ResponseEntity.ok(sale);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<SaleSummaryDTO>> searchSales(SearchSaleRequest request) {
        Page<SaleSummaryDTO> sales = saleService.searchSales(request);
        return ResponseEntity.ok(sales);
    }

    @Override
    @GetMapping("/recent")
    public ResponseEntity<List<SaleSummaryDTO>> getRecentSales(@RequestParam(defaultValue = "10") Integer limit) {
        List<SaleSummaryDTO> sales = saleService.getRecentSales(limit);
        return ResponseEntity.ok(sales);
    }

    @Override
    @PostMapping("/payment")
    public ResponseEntity<PaymentProcessResponse> processPayment(@Valid @RequestBody ProcessPaymentRequest request) {
        PaymentProcessResponse response = saleService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/report")
    public ResponseEntity<SalesReportDTO> getSalesReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        SalesReportDTO report = saleService.getSalesReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelSale(@PathVariable Long id, @RequestParam String reason) {
        saleService.cancelSale(id, reason);
        return ResponseEntity.noContent().build();
    }
}
