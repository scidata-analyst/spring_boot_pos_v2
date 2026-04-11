package com.example.pos.dtos.request.Products;

import jakarta.validation.constraints.*;
import java.time.*;

/**
 * =====================================================
 * Request DTO: ProductCatalog
 * =====================================================
 *
 * Auto-generated from schema.json
 * Includes all fields including audit fields
 */
public class ProductCatalogRequest {

    /**
     * id
     */
    @NotNull(message = "id is required")
    private Long id;

    /**
     * name
     */
    @NotBlank(message = "name is required")
    private String name;

    /**
     * sku
     */
    @NotBlank(message = "sku is required")
    private String sku;

    /**
     * barcodeId
     */
    @NotNull(message = "barcodeId is required")
    private Long barcodeId;

    /**
     * categoryId
     */
    @NotBlank(message = "categoryId is required")
    private String categoryId;

    /**
     * price
     */
    @NotNull(message = "price is required")
    private Double price;

    /**
     * cost
     */
    @NotNull(message = "cost is required")
    private Double cost;

    /**
     * stock
     */
    @NotNull(message = "stock is required")
    private Integer stock;

    /**
     * status
     */
    @NotBlank(message = "status is required")
    private String status;

    /**
     * unit
     */
    @NotBlank(message = "unit is required")
    private String unit;

    /**
     * salePrice
     */
    @NotNull(message = "salePrice is required")
    private Double salePrice;

    /**
     * costPrice
     */
    @NotNull(message = "costPrice is required")
    private Double costPrice;

    /**
     * stockQty
     */
    @NotNull(message = "stockQty is required")
    private Integer stockQty;

    /**
     * reorderLevel
     */
    @NotNull(message = "reorderLevel is required")
    private Integer reorderLevel;

    /**
     * taxRate
     */
    @NotBlank(message = "taxRate is required")
    private String taxRate;

    /**
     * createdAt
     */
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    /**
     * updatedAt
     */
    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;

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
