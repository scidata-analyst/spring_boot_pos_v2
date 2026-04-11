package com.example.pos.entities.PaymentAccounting;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: CashRegister
 * Table: cash_register
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "cash_register")
public class CashRegister {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * registerName
     */

    private String registerName;

    /**
     * openingBalance
     */

    private Double openingBalance;

    /**
     * closingBalance
     */

    private Double closingBalance;

    /**
     * cashIn
     */

    private Double cashIn;

    /**
     * cashOut
     */

    private Double cashOut;

    /**
     * status
     */

    private String status;

    /**
     * openedAt
     */

    private LocalDateTime openedAt;

    /**
     * closedAt
     */

    private LocalDateTime closedAt;

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
