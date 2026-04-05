package com.scidata_analyst.pos.controller.payment;

import com.scidata_analyst.pos.dto.payment.PaymentDTO;
import com.scidata_analyst.pos.dto.payment.PaymentSummaryDTO;
import com.scidata_analyst.pos.request.payment.CreatePaymentRequest;
import com.scidata_analyst.pos.request.payment.SearchPaymentRequest;
import com.scidata_analyst.pos.request.payment.UpdatePaymentRequest;
import com.scidata_analyst.pos.service.payment.PaymentService;
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
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@Valid @RequestBody CreatePaymentRequest request) {
        PaymentDTO created = paymentService.createPayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @Valid @RequestBody UpdatePaymentRequest request) {
        PaymentDTO updated = paymentService.updatePayment(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        PaymentDTO payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<Page<PaymentDTO>> searchPayments(SearchPaymentRequest request) {
        Page<PaymentDTO> payments = paymentService.searchPayments(request);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/sale/{saleId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsBySaleId(@PathVariable Long saleId) {
        List<PaymentDTO> payments = paymentService.getPaymentsBySaleId(saleId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/summary")
    public ResponseEntity<PaymentSummaryDTO> getPaymentSummary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        PaymentSummaryDTO summary = paymentService.getPaymentSummary(startDate, endDate);
        return ResponseEntity.ok(summary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelPayment(@PathVariable Long id, @RequestParam String reason) {
        paymentService.cancelPayment(id, reason);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sale/{saleId}/total")
    public ResponseEntity<BigDecimal> getTotalPaymentsBySale(@PathVariable Long saleId) {
        BigDecimal total = paymentService.getTotalPaymentsBySale(saleId);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/sale/{saleId}/balance")
    public ResponseEntity<Map<String, Object>> getSalePaymentBalance(@PathVariable Long saleId) {
        Map<String, Object> balance = paymentService.getSalePaymentBalance(saleId);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/method-summary")
    public ResponseEntity<Map<String, BigDecimal>> getPaymentsByMethod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Map<String, BigDecimal> summary = paymentService.getPaymentsByMethod(startDate, endDate);
        return ResponseEntity.ok(summary);
    }
}
