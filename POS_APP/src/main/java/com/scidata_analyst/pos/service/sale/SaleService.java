package com.scidata_analyst.pos.service.sale;

import com.scidata_analyst.pos.controller.sale.SaleController.SaleItemRequest;
import com.scidata_analyst.pos.dto.sale.SaleDTO;
import com.scidata_analyst.pos.dto.sale.SaleItemResponse;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.dto.sale.SalesReportDTO;
import com.scidata_analyst.pos.request.sale.CreateSaleRequest;
import com.scidata_analyst.pos.request.sale.ProcessPaymentRequest;
import com.scidata_analyst.pos.request.sale.SearchSaleRequest;
import com.scidata_analyst.pos.request.sale.UpdateSaleRequest;
import com.scidata_analyst.pos.response.sale.PaymentProcessResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SaleService {

    SaleDTO createSale(CreateSaleRequest request);

    SaleDTO updateSale(Long id, UpdateSaleRequest request);

    SaleDTO getSaleById(Long id);

    SaleDTO getSaleByInvoiceNumber(String invoiceNumber);

    Page<SaleSummaryDTO> searchSales(SearchSaleRequest request);

    List<SaleSummaryDTO> getRecentSales(Integer limit);

    PaymentProcessResponse processPayment(ProcessPaymentRequest request);

    SalesReportDTO getSalesReport(LocalDate startDate, LocalDate endDate);

    void deleteSale(Long id);

    void cancelSale(Long id, String reason);

    String generateInvoiceNumber();

    BigDecimal getTotalSalesByDateRange(LocalDate startDate, LocalDate endDate);

    Long getTotalTransactionsByDateRange(LocalDate startDate, LocalDate endDate);

    List<SaleItemResponse> getSaleItems(Long saleId);

    SaleItemResponse addSaleItem(Long saleId, SaleItemRequest request);

    SaleItemResponse updateSaleItem(Long saleId, Long itemId, SaleItemRequest request);

    void removeSaleItem(Long saleId, Long itemId);

    Map<String, Object> getSaleCustomer(Long saleId);

    SaleDTO assignToCustomer(Long saleId, Long customerId);

    SaleDTO removeCustomer(Long saleId);

    List<Map<String, Object>> getSalePayments(Long saleId);

    BigDecimal getSaleTotal(Long saleId);

    Map<String, Object> getDailySalesSummary(LocalDate date);

    List<SaleSummaryDTO> getSalesByUser(Long userId);
}
