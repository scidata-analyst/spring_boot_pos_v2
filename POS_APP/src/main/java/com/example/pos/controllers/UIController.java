package com.example.pos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/")
    public String index() {
        return "Core/index";
    }

    @GetMapping("/pos-terminal")
    public String posTerminal() {
        return "Core/pos-terminal";
    }

    @GetMapping("/customers")
    public String customers() {
        return "Customers/customers";
    }

    @GetMapping("/loyalty-points")
    public String loyaltyPoints() {
        return "Customers/loyalty-points";
    }

    @GetMapping("/memberships")
    public String memberships() {
        return "Customers/memberships";
    }

    @GetMapping("/purchase-history")
    public String purchaseHistory() {
        return "Customers/purchase-history";
    }

    @GetMapping("/cash-drawer")
    public String cashDrawer() {
        return "Hardware/cash-drawer";
    }

    @GetMapping("/devices")
    public String devices() {
        return "Hardware/devices";
    }

    @GetMapping("/qr-mobile")
    public String qrMobile() {
        return "Hardware/qr-mobile";
    }

    @GetMapping("/points-config")
    public String pointsConfig() {
        return "Loyalty/points-config";
    }

    @GetMapping("/retention")
    public String retention() {
        return "Loyalty/retention";
    }

    @GetMapping("/tier-management")
    public String tierManagement() {
        return "Loyalty/tier-management";
    }

    @GetMapping("/catalog")
    public String catalog() {
        return "Products/catalog";
    }

    @GetMapping("/categories")
    public String categories() {
        return "Products/categories";
    }

    @GetMapping("/barcodes")
    public String barcodes() {
        return "Products/barcodes";
    }

    @GetMapping("/batch-expiry")
    public String batchExpiry() {
        return "Products/batch-expiry";
    }

    @GetMapping("/stock-movement")
    public String stockMovement() {
        return "Products/stock-movement";
    }

    @GetMapping("/coupons")
    public String coupons() {
        return "Promos/coupons";
    }

    @GetMapping("/happy-hour")
    public String happyHour() {
        return "Promos/happy-hour";
    }

    @GetMapping("/offers")
    public String offers() {
        return "Promos/offers";
    }

    @GetMapping("/custom-report")
    public String customReport() {
        return "Reports/custom-report";
    }

    @GetMapping("/pl-report")
    public String plReport() {
        return "Reports/pl-report";
    }

    @GetMapping("/sales-report")
    public String salesReport() {
        return "Reports/sales-report";
    }

    @GetMapping("/stock-report")
    public String stockReport() {
        return "Reports/stock-report";
    }

    @GetMapping("/held-orders")
    public String heldOrders() {
        return "Sales/held-orders";
    }

    @GetMapping("/invoices")
    public String invoices() {
        return "Sales/invoices";
    }

    @GetMapping("/returns")
    public String returns() {
        return "Sales/returns";
    }

    @GetMapping("/transactions")
    public String transactions() {
        return "Sales/transactions";
    }

    @GetMapping("/suppliers")
    public String suppliers() {
        return "Suppliers/suppliers";
    }

    @GetMapping("/restock-alerts")
    public String restockAlerts() {
        return "Suppliers/restock-alerts";
    }

    @GetMapping("/supplier-payments")
    public String supplierPayments() {
        return "Suppliers/supplier-payments";
    }

    @GetMapping("/purchase-orders")
    public String purchaseOrders() {
        return "Suppliers/purchase-orders";
    }

    @GetMapping("/activity-log")
    public String activityLog() {
        return "Users/activity-log";
    }

    @GetMapping("/cashiers")
    public String cashiers() {
        return "Users/cashiers";
    }

    @GetMapping("/roles")
    public String roles() {
        return "Users/roles";
    }

    @GetMapping("/ap-ar")
    public String apAr() {
        return "Accounting/ap-ar";
    }

    @GetMapping("/cash-register")
    public String cashRegister() {
        return "Accounting/cash-register";
    }

    @GetMapping("/reconciliation")
    public String reconciliation() {
        return "Accounting/reconciliation";
    }

    @GetMapping("/tax-reports")
    public String taxReports() {
        return "Accounting/tax-reports";
    }
}