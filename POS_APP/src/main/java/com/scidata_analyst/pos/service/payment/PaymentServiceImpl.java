package com.scidata_analyst.pos.service.payment;

import com.scidata_analyst.pos.dto.payment.PaymentDTO;
import com.scidata_analyst.pos.dto.payment.PaymentSummaryDTO;
import com.scidata_analyst.pos.entity.Payment;
import com.scidata_analyst.pos.entity.Sale;
import com.scidata_analyst.pos.repository.payment.PaymentRepository;
import com.scidata_analyst.pos.repository.sale.SaleRepository;
import com.scidata_analyst.pos.request.payment.CreatePaymentRequest;
import com.scidata_analyst.pos.request.payment.SearchPaymentRequest;
import com.scidata_analyst.pos.request.payment.UpdatePaymentRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final SaleRepository saleRepository;

    @Override
    public PaymentDTO createPayment(CreatePaymentRequest request) {
        Sale sale = saleRepository.findById(request.getSaleId())
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + request.getSaleId()));

        Payment payment = Payment.builder()
                .sale(sale)
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .transactionReference(request.getTransactionReference())
                .notes(request.getNotes())
                .build();

        Payment saved = paymentRepository.save(payment);
        return mapToDTO(saved);
    }

    @Override
    public PaymentDTO updatePayment(Long id, UpdatePaymentRequest request) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));

        if (request.getStatus() != null) payment.setStatus(request.getStatus());
        if (request.getNotes() != null) payment.setNotes(request.getNotes());

        Payment updated = paymentRepository.save(payment);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));
        return mapToDTO(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentDTO> searchPayments(SearchPaymentRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        LocalDateTime startDate = request.getStartDate() != null ? request.getStartDate().atStartOfDay() : null;
        LocalDateTime endDate = request.getEndDate() != null ? request.getEndDate().atTime(23, 59, 59) : null;

        Page<Payment> payments = paymentRepository.searchPayments(
                request.getSaleId(),
                request.getPaymentMethod(),
                request.getStatus(),
                startDate,
                endDate,
                pageable
        );

        return payments.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentDTO> getPaymentsBySaleId(Long saleId) {
        return paymentRepository.findBySaleId(saleId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentSummaryDTO getPaymentSummary(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        BigDecimal totalAmount = paymentRepository.getTotalPaymentsByDateRange(start, end);
        BigDecimal cashAmount = paymentRepository.getTotalPaymentsByMethod("CASH", start, end);
        BigDecimal cardAmount = paymentRepository.getTotalPaymentsByMethod("CARD", start, end);
        BigDecimal otherAmount = totalAmount.subtract(cashAmount).subtract(cardAmount);

        return PaymentSummaryDTO.builder()
                .date(startDate)
                .totalTransactions(0L)
                .totalAmount(totalAmount)
                .cashAmount(cashAmount)
                .cardAmount(cardAmount)
                .otherAmount(otherAmount)
                .successfulPayments(totalAmount)
                .failedPayments(BigDecimal.ZERO)
                .pendingPayments(BigDecimal.ZERO)
                .build();
    }

    @Override
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new EntityNotFoundException("Payment not found with id: " + id);
        }
        paymentRepository.deleteById(id);
    }

    @Override
    public void cancelPayment(Long id, String reason) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));
        payment.setStatus("CANCELLED");
        payment.setNotes(reason);
        paymentRepository.save(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getTotalPaymentsByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return paymentRepository.getTotalPaymentsByDateRange(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getTotalPaymentsByMethod(String paymentMethod, LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return paymentRepository.getTotalPaymentsByMethod(paymentMethod, start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getTotalPaymentsBySale(Long saleId) {
        return paymentRepository.findBySaleId(saleId)
                .stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getSalePaymentBalance(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id: " + saleId));

        BigDecimal totalPaid = paymentRepository.findBySaleId(saleId)
                .stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = sale.getTotal().subtract(totalPaid);

        Map<String, Object> result = new HashMap<>();
        result.put("saleId", sale.getId());
        result.put("invoiceNumber", sale.getInvoiceNumber());
        result.put("totalAmount", sale.getTotal());
        result.put("totalPaid", totalPaid);
        result.put("balance", balance);
        result.put("isPaid", balance.compareTo(BigDecimal.ZERO) <= 0);
        result.put("status", balance.compareTo(BigDecimal.ZERO) <= 0 ? "PAID" : "PENDING");
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, BigDecimal> getPaymentsByMethod(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        Map<String, BigDecimal> summary = new HashMap<>();
        summary.put("CASH", paymentRepository.getTotalPaymentsByMethod("CASH", start, end));
        summary.put("CARD", paymentRepository.getTotalPaymentsByMethod("CARD", start, end));
        summary.put("TRANSFER", paymentRepository.getTotalPaymentsByMethod("TRANSFER", start, end));
        summary.put("TOTAL", paymentRepository.getTotalPaymentsByDateRange(start, end));
        return summary;
    }

    private PaymentDTO mapToDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .saleId(payment.getSale().getId())
                .invoiceNumber(payment.getSale().getInvoiceNumber())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .transactionReference(payment.getTransactionReference())
                .status(payment.getStatus())
                .notes(payment.getNotes())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }
}
