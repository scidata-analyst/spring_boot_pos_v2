package com.scidata_analyst.pos.service.product;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.product.ProductPriceDTO;
import com.scidata_analyst.pos.dto.product.ProductStockDTO;
import com.scidata_analyst.pos.entity.Category;
import com.scidata_analyst.pos.entity.Product;
import com.scidata_analyst.pos.entity.Supplier;
import com.scidata_analyst.pos.repository.category.CategoryRepository;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import com.scidata_analyst.pos.repository.supplier.SupplierRepository;
import com.scidata_analyst.pos.request.product.CreateProductRequest;
import com.scidata_analyst.pos.request.product.SearchProductRequest;
import com.scidata_analyst.pos.request.product.UpdateProductRequest;
import com.scidata_analyst.pos.request.product.UpdateStockRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public ProductDTO createProduct(CreateProductRequest request) {
        if (productRepository.existsByBarcode(request.getBarcode())) {
            throw new IllegalArgumentException("Product with barcode " + request.getBarcode() + " already exists");
        }

        Product product = Product.builder()
                .barcode(request.getBarcode())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .costPrice(request.getCostPrice())
                .stockQuantity(request.getStockQuantity())
                .reorderLevel(request.getReorderLevel())
                .category(request.getCategoryId() != null ? categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + request.getCategoryId())) : null)
                .supplier(request.getSupplierId() != null ? supplierRepository.findById(request.getSupplierId())
                        .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + request.getSupplierId())) : null)
                .build();

        Product saved = productRepository.save(product);
        return mapToDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        if (request.getName() != null) product.setName(request.getName());
        if (request.getDescription() != null) product.setDescription(request.getDescription());
        if (request.getPrice() != null) product.setPrice(request.getPrice());
        if (request.getCostPrice() != null) product.setCostPrice(request.getCostPrice());
        if (request.getStockQuantity() != null) product.setStockQuantity(request.getStockQuantity());
        if (request.getReorderLevel() != null) product.setReorderLevel(request.getReorderLevel());
        if (request.getIsActive() != null) product.setIsActive(request.getIsActive());

        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + request.getCategoryId()));
            product.setCategory(category);
        }

        if (request.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(request.getSupplierId())
                    .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + request.getSupplierId()));
            product.setSupplier(supplier);
        }

        Product updated = productRepository.save(product);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return mapToDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductByBarcode(String barcode) {
        Product product = productRepository.findByBarcode(barcode)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with barcode: " + barcode));
        return mapToDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> searchProducts(SearchProductRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<Product> products = productRepository.searchProducts(
                request.getKeyword(),
                request.getCategoryId(),
                request.getSupplierId(),
                request.getIsActive(),
                request.getMinStock(),
                pageable
        );

        return products.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllActiveProducts() {
        return productRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductStockDTO updateStock(UpdateStockRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + request.getProductId()));

        int currentStock = product.getStockQuantity();
        int newStock;

        switch (request.getOperation()) {
            case ADD:
                newStock = currentStock + request.getQuantity();
                break;
            case SUBTRACT:
                newStock = currentStock - request.getQuantity();
                if (newStock < 0) throw new IllegalArgumentException("Insufficient stock");
                break;
            case SET:
                newStock = request.getQuantity();
                break;
            default:
                throw new IllegalArgumentException("Invalid stock operation");
        }

        product.setStockQuantity(newStock);
        productRepository.save(product);

        return mapToStockDTO(product);
    }

    @Override
    public ProductPriceDTO updatePrice(Long id, ProductPriceDTO priceDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        if (priceDTO.getPrice() != null) product.setPrice(priceDTO.getPrice());
        if (priceDTO.getCostPrice() != null) product.setCostPrice(priceDTO.getCostPrice());

        productRepository.save(product);

        BigDecimal margin = product.getPrice().subtract(product.getCostPrice() != null ? product.getCostPrice() : BigDecimal.ZERO);
        Double marginPercentage = product.getCostPrice() != null && product.getCostPrice().compareTo(BigDecimal.ZERO) > 0
                ? (margin.doubleValue() / product.getCostPrice().doubleValue()) * 100
                : 0.0;

        return ProductPriceDTO.builder()
                .id(product.getId())
                .barcode(product.getBarcode())
                .name(product.getName())
                .costPrice(product.getCostPrice())
                .price(product.getPrice())
                .margin(margin)
                .marginPercentage(marginPercentage)
                .build();
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public void deactivateProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        product.setIsActive(false);
        productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByBarcode(String barcode) {
        return productRepository.existsByBarcode(barcode);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductStockDTO getProductStock(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return mapToStockDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getLowStockProducts(Integer threshold) {
        return productRepository.findByStockQuantityLessThanEqual(threshold)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsBySupplier(Long supplierId) {
        return productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO assignToCategory(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
        product.setCategory(category);
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO assignToSupplier(Long productId, Long supplierId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + supplierId));
        product.setSupplier(supplier);
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO removeFromCategory(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        product.setCategory(null);
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO removeFromSupplier(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        product.setSupplier(null);
        return mapToDTO(productRepository.save(product));
    }

    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .barcode(product.getBarcode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .costPrice(product.getCostPrice())
                .stockQuantity(product.getStockQuantity())
                .reorderLevel(product.getReorderLevel())
                .isActive(product.getIsActive())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .supplierId(product.getSupplier() != null ? product.getSupplier().getId() : null)
                .supplierName(product.getSupplier() != null ? product.getSupplier().getName() : null)
                .build();
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
