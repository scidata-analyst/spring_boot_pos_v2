package com.example.pos.entity.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_catalog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String sku;

    private Long barcodeId;

    private String categoryId;

    private Double price;

    private Double cost;

    private Integer stock;

    private String status;

    private String unit;

    private Double salePrice;

    private Double costPrice;

    private Integer stockQty;

    private Integer reorderLevel;

    private String taxRate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
