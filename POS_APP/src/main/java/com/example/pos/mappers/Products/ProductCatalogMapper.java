package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.ProductCatalog;
import com.example.pos.dtos.request.Products.ProductCatalogRequest;
import com.example.pos.dtos.response.Products.ProductCatalogResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCatalogMapper {

    public ProductCatalogResponse toResponse(ProductCatalog entity) {
        if (entity == null)
            return null;

        ProductCatalogResponse response = new ProductCatalogResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSku(entity.getSku());
        response.setBarcodeId(entity.getBarcodeId());
        response.setCategoryId(entity.getCategoryId());
        response.setPrice(entity.getPrice());
        response.setCost(entity.getCost());
        response.setStock(entity.getStock());
        response.setStatus(entity.getStatus());
        response.setUnit(entity.getUnit());
        response.setSalePrice(entity.getSalePrice());
        response.setCostPrice(entity.getCostPrice());
        response.setStockQty(entity.getStockQty());
        response.setReorderLevel(entity.getReorderLevel());
        response.setTaxRate(entity.getTaxRate());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public ProductCatalog toEntity(ProductCatalogRequest request) {
        if (request == null)
            return null;

        ProductCatalog entity = new ProductCatalog();

        entity.setName(request.getName());
        entity.setSku(request.getSku());
        entity.setBarcodeId(request.getBarcodeId());
        entity.setCategoryId(request.getCategoryId());
        entity.setPrice(request.getPrice());
        entity.setCost(request.getCost());
        entity.setStock(request.getStock());
        entity.setStatus(request.getStatus());
        entity.setUnit(request.getUnit());
        entity.setSalePrice(request.getSalePrice());
        entity.setCostPrice(request.getCostPrice());
        entity.setStockQty(request.getStockQty());
        entity.setReorderLevel(request.getReorderLevel());
        entity.setTaxRate(request.getTaxRate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(ProductCatalogRequest request, ProductCatalog entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setSku(request.getSku());
        entity.setBarcodeId(request.getBarcodeId());
        entity.setCategoryId(request.getCategoryId());
        entity.setPrice(request.getPrice());
        entity.setCost(request.getCost());
        entity.setStock(request.getStock());
        entity.setStatus(request.getStatus());
        entity.setUnit(request.getUnit());
        entity.setSalePrice(request.getSalePrice());
        entity.setCostPrice(request.getCostPrice());
        entity.setStockQty(request.getStockQty());
        entity.setReorderLevel(request.getReorderLevel());
        entity.setTaxRate(request.getTaxRate());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<ProductCatalogResponse> toResponseList(List<ProductCatalog> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
