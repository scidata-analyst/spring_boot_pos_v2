package com.scidata_analyst.pos.service.product;

import com.scidata_analyst.pos.dto.product.ProductStockDTO;

import java.util.List;

public interface ProductStockService {

    ProductStockDTO getStockByProductId(Long productId);

    List<ProductStockDTO> getLowStockProducts(Integer threshold);

    ProductStockDTO adjustStock(Long productId, Integer quantityChange, String notes);

    ProductStockDTO setStock(Long productId, Integer newQuantity, String notes);

    boolean isLowStock(Long productId);

    List<ProductStockDTO> getAllStockLevels();
}
