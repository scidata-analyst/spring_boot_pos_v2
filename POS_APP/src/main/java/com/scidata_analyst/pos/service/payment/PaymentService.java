package com.scidata_analyst.pos.service.payment;

import com.scidata_analyst.pos.dto.payment.PaymentDTO;
import com.scidata_analyst.pos.dto.payment.PaymentSummaryDTO;
import com.scidata_analyst.pos.request.payment.CreatePaymentRequest;
import com.scidata_analyst.pos.request.payment.SearchPaymentRequest;
import com.scidata_analyst.pos.request.payment.UpdatePaymentRequest;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface PaymentService {

    PaymentDTO createPayment(CreatePaymentRequest request);

    PaymentDTO updatePayment(Long id, UpdatePaymentRequest request);

    PaymentDTO getPaymentById(Long id);

    Page<PaymentDTO> searchPayments(SearchPaymentRequest request);

    List<PaymentDTO> getPaymentsBySaleId(Long saleId);

    PaymentSummaryDTO getPaymentSummary(LocalDate startDate, LocalDate endDate);

    void deletePayment(Long id);

    void cancelPayment(Long id, String reason);

    BigDecimal getTotalPaymentsByDateRange(LocalDate startDate, LocalDate endDate);

    BigDecimal getTotalPaymentsByMethod(String paymentMethod, LocalDate startDate, LocalDate endDate);

    BigDecimal getTotalPaymentsBySale(Long saleId);

    Map<String, Object> getSalePaymentBalance(Long saleId);

    Map<String, BigDecimal> getPaymentsByMethod(LocalDate startDate, LocalDate endDate);
}
