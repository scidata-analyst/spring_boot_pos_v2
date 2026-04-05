package com.scidata_analyst.pos.service.inventory;

import com.scidata_analyst.pos.dto.inventory.InventoryDTO;
import com.scidata_analyst.pos.dto.inventory.InventoryLogDTO;
import com.scidata_analyst.pos.dto.inventory.InventorySummaryDTO;
import com.scidata_analyst.pos.entity.InventoryLog;
import com.scidata_analyst.pos.entity.Product;
import com.scidata_analyst.pos.repository.inventory.InventoryLogRepository;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import com.scidata_analyst.pos.request.inventory.AdjustInventoryRequest;
import com.scidata_analyst.pos.request.inventory.LowStockAlertRequest;
import com.scidata_analyst.pos.request.inventory.SearchInventoryRequest;
import com.scidata_analyst.pos.response.inventory.InventoryAdjustResponse;
import com.scidata_analyst.pos.response.inventory.LowStockAlertResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryLogRepository inventoryLogRepository;
    private final ProductRepository productRepository;

    @Override
    public InventoryAdjustResponse adjustInventory(AdjustInventoryRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + request.getProductId()));

        int quantityBefore = product.getStockQuantity();
        int quantityAfter;

        switch (request.getType()) {
            case RECEIVE:
            case ADJUSTMENT:
            case STOCK_TAKE:
                quantityAfter = quantityBefore + request.getQuantityChange();
                break;
            case RETURN:
                quantityAfter = quantityBefore + request.getQuantityChange();
                break;
            case DAMAGE:
                quantityAfter = quantityBefore - Math.abs(request.getQuantityChange());
                break;
            default:
                throw new IllegalArgumentException("Invalid adjustment type");
        }

        if (quantityAfter < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        product.setStockQuantity(quantityAfter);
        productRepository.save(product);

        InventoryLog log = InventoryLog.builder()
                .product(product)
                .quantityChange(request.getQuantityChange())
                .quantityBefore(quantityBefore)
                .quantityAfter(quantityAfter)
                .type(request.getType().name())
                .reference(request.getReference())
                .notes(request.getNotes())
                .build();

        inventoryLogRepository.save(log);

        return InventoryAdjustResponse.builder()
                .id(log.getId())
                .productId(product.getId())
                .productName(product.getName())
                .previousStock(quantityBefore)
                .quantityChanged(request.getQuantityChange())
                .currentStock(quantityAfter)
                .type(request.getType().name())
                .reference(request.getReference())
                .notes(request.getNotes())
                .adjustedBy("SYSTEM")
                .adjustedAt(LocalDateTime.now().toString())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InventoryLogDTO> searchInventoryLogs(SearchInventoryRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<InventoryLog> logs = inventoryLogRepository.searchInventoryLogs(
                request.getProductId(),
                request.getType(),
                request.getReference(),
                pageable
        );

        return logs.map(this::mapToLogDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LowStockAlertResponse> getLowStockAlerts(LowStockAlertRequest request) {
        List<Product> lowStockProducts = productRepository.findLowStockProducts();

        return lowStockProducts.stream()
                .map(product -> LowStockAlertResponse.builder()
                        .productId(product.getId())
                        .productName(product.getName())
                        .barcode(product.getBarcode())
                        .currentStock(product.getStockQuantity())
                        .reorderLevel(product.getReorderLevel())
                        .stockDifference(product.getReorderLevel() - product.getStockQuantity())
                        .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                        .supplierName(product.getSupplier() != null ? product.getSupplier().getName() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public InventorySummaryDTO getInventorySummary() {
        List<Product> allProducts = productRepository.findAll();

        long totalProducts = allProducts.size();
        long activeProducts = allProducts.stream().filter(Product::getIsActive).count();
        long lowStockProducts = allProducts.stream().filter(p -> p.getStockQuantity() <= p.getReorderLevel()).count();
        long outOfStockProducts = allProducts.stream().filter(p -> p.getStockQuantity() == 0).count();

        int totalStockQuantity = allProducts.stream().mapToInt(Product::getStockQuantity).sum();

        BigDecimal totalStockValue = allProducts.stream()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCostValue = allProducts.stream()
                .map(p -> p.getCostPrice() != null ? p.getCostPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())) : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return InventorySummaryDTO.builder()
                .totalProducts(totalProducts)
                .activeProducts(activeProducts)
                .lowStockProducts(lowStockProducts)
                .outOfStockProducts(outOfStockProducts)
                .totalStockQuantity(totalStockQuantity)
                .totalStockValue(totalStockValue)
                .totalCostValue(totalCostValue)
                .averageStockLevel(totalProducts > 0 ? (double) totalStockQuantity / totalProducts : 0.0)
                .inventoryTurnoverRate(0.0)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public InventoryDTO getInventoryByProductId(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        return mapToInventoryDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryDTO> getAllInventoryLevels() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToInventoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public InventoryLogDTO getInventoryLogById(Long id) {
        InventoryLog log = inventoryLogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inventory log not found with id: " + id));
        return mapToLogDTO(log);
    }

    @Override
    public void recordStockMovement(Long productId, Integer quantityChange, String type, String notes) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        int quantityBefore = product.getStockQuantity();
        int quantityAfter = quantityBefore + quantityChange;

        if (quantityAfter < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        product.setStockQuantity(quantityAfter);
        productRepository.save(product);

        InventoryLog log = InventoryLog.builder()
                .product(product)
                .quantityChange(quantityChange)
                .quantityBefore(quantityBefore)
                .quantityAfter(quantityAfter)
                .type(type)
                .notes(notes)
                .build();

        inventoryLogRepository.save(log);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryLogDTO> getProductInventoryLogs(Long productId) {
        return inventoryLogRepository.findByProductIdOrderByCreatedAtDesc(productId)
                .stream()
                .map(this::mapToLogDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InventoryLogDTO> getProductInventoryLogsPage(Long productId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return inventoryLogRepository.findByProductId(productId, pageable)
                .map(this::mapToLogDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryDTO> getInventoryByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToInventoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryDTO> getInventoryBySupplier(Long supplierId) {
        return productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToInventoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getInventoryValueSummary() {
        List<Product> allProducts = productRepository.findAll();

        BigDecimal totalStockValue = allProducts.stream()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCostValue = allProducts.stream()
                .map(p -> p.getCostPrice() != null ? p.getCostPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())) : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal potentialProfit = totalStockValue.subtract(totalCostValue);

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalProducts", allProducts.size());
        summary.put("totalStockQuantity", allProducts.stream().mapToInt(Product::getStockQuantity).sum());
        summary.put("totalStockValue", totalStockValue);
        summary.put("totalCostValue", totalCostValue);
        summary.put("potentialProfit", potentialProfit);
        summary.put("profitMargin", totalCostValue.compareTo(BigDecimal.ZERO) > 0
                ? (potentialProfit.doubleValue() / totalCostValue.doubleValue()) * 100
                : 0.0);
        return summary;
    }

    @Override
    @Transactional
    public List<InventoryAdjustResponse> bulkAdjustInventory(List<AdjustInventoryRequest> requests) {
        return requests.stream()
                .map(this::adjustInventory)
                .collect(Collectors.toList());
    }

    private InventoryDTO mapToInventoryDTO(Product product) {
        return InventoryDTO.builder()
                .productId(product.getId())
                .productName(product.getName())
                .barcode(product.getBarcode())
                .currentStock(product.getStockQuantity())
                .reorderLevel(product.getReorderLevel())
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .supplierName(product.getSupplier() != null ? product.getSupplier().getName() : null)
                .isLowStock(product.getStockQuantity() <= product.getReorderLevel())
                .stockValue(product.getStockQuantity())
                .build();
    }

    private InventoryLogDTO mapToLogDTO(InventoryLog log) {
        return InventoryLogDTO.builder()
                .id(log.getId())
                .productId(log.getProduct().getId())
                .productName(log.getProduct().getName())
                .barcode(log.getProduct().getBarcode())
                .quantityChange(log.getQuantityChange())
                .quantityBefore(log.getQuantityBefore())
                .quantityAfter(log.getQuantityAfter())
                .type(log.getType())
                .reference(log.getReference())
                .notes(log.getNotes())
                .adjustedBy(log.getUser() != null ? log.getUser().getUsername() : "SYSTEM")
                .createdAt(log.getCreatedAt())
                .build();
    }
}
