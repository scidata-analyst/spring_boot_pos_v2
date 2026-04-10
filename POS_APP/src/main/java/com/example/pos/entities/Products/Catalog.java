package com.example.pos.entities.Products;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing product catalog information.
 * Maps to the product_catalog table in the database.
 */
@Entity
@Table(name = "product_catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "sku", length = 100, unique = true)
    private String sku;

    @Column(name = "barcode_id")
    private Long barcodeId;

    @Column(name = "category_id", length = 50)
    private String categoryId;

    @Column(name = "price")
    private Double price;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "unit", length = 50)
    private String unit;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "stock_qty")
    private Integer stockQty;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "tax_rate", length = 20)
    private String taxRate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Catalog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(Long barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}