package com.example.pos.entities.Payment;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing cash register sessions.
 * Maps to the cash_register table in the database.
 */
@Entity
@Table(name = "cash_register")
public class CashRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "register_name", length = 100)
    private String registerName;

    @Column(name = "opening_balance")
    private Double openingBalance;

    @Column(name = "closing_balance")
    private Double closingBalance;

    @Column(name = "cash_in")
    private Double cashIn;

    @Column(name = "cash_out")
    private Double cashOut;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "opened_at")
    private LocalDateTime openedAt;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public CashRegister() {
    }

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