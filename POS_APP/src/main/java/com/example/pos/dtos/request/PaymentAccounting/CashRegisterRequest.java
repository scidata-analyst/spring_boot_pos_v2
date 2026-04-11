package com.example.pos.dtos.request.PaymentAccounting;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: CashRegister
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class CashRegisterRequest {


    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * registerName
     */
    @NotBlank(message = "registerName is required")
    private String registerName;

    /**
     * openingBalance
     */
    @NotNull(message = "openingBalance is required")
    private Double openingBalance;

    /**
     * closingBalance
     */
    @NotNull(message = "closingBalance is required")
    private Double closingBalance;

    /**
     * cashIn
     */
    @NotNull(message = "cashIn is required")
    private Double cashIn;

    /**
     * cashOut
     */
    @NotNull(message = "cashOut is required")
    private Double cashOut;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * openedAt
     */
    @NotNull(message = "openedAt is required")
    private LocalDateTime openedAt;

    /**
     * closedAt
     */
    @NotNull(message = "closedAt is required")
    private LocalDateTime closedAt;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Double getCashIn() {
        return cashIn;
    }

    public void setCashIn(Double cashIn) {
        this.cashIn = cashIn;
    }

    public Double getCashOut() {
        return cashOut;
    }

    public void setCashOut(Double cashOut) {
        this.cashOut = cashOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
