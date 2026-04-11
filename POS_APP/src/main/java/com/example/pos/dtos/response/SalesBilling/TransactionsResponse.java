package com.example.pos.dtos.response.SalesBilling;

import java.time.LocalDateTime;

/**
 * =====================================================
 * Response DTO: Transactions
 * =====================================================
 *
 * Auto-generated from schema.json
 * Used for API responses only (read-only layer)
 */
public class TransactionsResponse {

    /**
     * id
     */
    private Long id;

    /**
     * invoiceNumber
     */
    private String invoiceNumber;

    /**
     * customerId
     */
    private Long customerId;

    /**
     * subtotal
     */
    private Double subtotal;

    /**
     * tax
     */
    private Double tax;

    /**
     * discount
     */
    private Double discount;

    /**
     * totalAmount
     */
    private Double totalAmount;

    /**
     * paymentMethod
     */
    private String paymentMethod;

    /**
     * cashierId
     */
    private Long cashierId;

    /**
     * status
     */
    private String status;

    /**
     * transactionDate
     */
    private LocalDateTime transactionDate;

    /**
     * createdAt
     */
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
