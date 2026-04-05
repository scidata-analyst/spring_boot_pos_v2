package com.scidata_analyst.pos.service.product;

import com.scidata_analyst.pos.dto.product.ProductStockDTO;
import com.scidata_analyst.pos.entity.Product;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductStockServiceImpl implements ProductStockService {

    private final ProductRepository productRepository;

    @Override
    public ProductStockDTO getStockByProductId(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Product not found with id: " + productId));
        return mapToStockDTO(product);
    }

    @Override
    public List<ProductStockDTO> getLowStockProducts(Integer threshold) {
        return productRepository.findByStockQuantityLessThanEqual(threshold)
                .stream()
                .map(this::mapToStockDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductStockDTO adjustStock(Long productId, Integer quantityChange, String notes) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Product not found with id: " + productId));

        int newStock = product.getStockQuantity() + quantityChange;
        if (newStock < 0) throw new IllegalArgumentException("Insufficient stock");

        product.setStockQuantity(newStock);
        productRepository.save(product);
        return mapToStockDTO(product);
    }

    @Override
    @Transactional
    public ProductStockDTO setStock(Long productId, Integer newQuantity, String notes) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Product not found with id: " + productId));

        if (newQuantity < 0) throw new IllegalArgumentException("Stock quantity cannot be negative");

        product.setStockQuantity(newQuantity);
        productRepository.save(product);
        return mapToStockDTO(product);
    }

    @Override
    public boolean isLowStock(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Product not found with id: " + productId));
        return product.getStockQuantity() <= product.getReorderLevel();
    }

    @Override
    public List<ProductStockDTO> getAllStockLevels() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToStockDTO)
                .collect(Collectors.toList());
    }

    private ProductStockDTO mapToStockDTO(Product product) {
        return ProductStockDTO.builder()
                .productId(product.getId())
                .productName(product.getName())
                .barcode(product.getBarcode())
                .currentStock(product.getStockQuantity())
                .reorderLevel(product.getReorderLevel())
                .isLowStock(product.getStockQuantity() <= product.getReorderLevel())
                .costPrice(product.getCostPrice())
                .price(product.getPrice())
                .stockValue(product.getPrice().multiply(BigDecimal.valueOf(product.getStockQuantity())))
                .build();
    }
}
