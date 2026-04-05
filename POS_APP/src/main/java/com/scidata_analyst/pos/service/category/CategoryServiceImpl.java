package com.scidata_analyst.pos.service.category;

import com.scidata_analyst.pos.dto.category.CategoryDTO;
import com.scidata_analyst.pos.dto.category.CategoryStatsDTO;
import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.entity.Category;
import com.scidata_analyst.pos.entity.Product;
import com.scidata_analyst.pos.repository.category.CategoryRepository;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import com.scidata_analyst.pos.request.category.CreateCategoryRequest;
import com.scidata_analyst.pos.request.category.SearchCategoryRequest;
import com.scidata_analyst.pos.request.category.UpdateCategoryRequest;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public CategoryDTO createCategory(CreateCategoryRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Category with name " + request.getName() + " already exists");
        }

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Category saved = categoryRepository.save(category);
        return mapToDTO(saved);
    }

    @Override
    public CategoryDTO updateCategory(Long id, UpdateCategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));

        if (request.getName() != null) {
            if (!category.getName().equals(request.getName()) && categoryRepository.existsByName(request.getName())) {
                throw new IllegalArgumentException("Category with name " + request.getName() + " already exists");
            }
            category.setName(request.getName());
        }
        if (request.getDescription() != null) category.setDescription(request.getDescription());
        if (request.getIsActive() != null) category.setIsActive(request.getIsActive());

        Category updated = categoryRepository.save(category);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return mapToDTO(category);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with name: " + name));
        return mapToDTO(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryDTO> searchCategories(SearchCategoryRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<Category> categories;
        if (request.getKeyword() != null && !request.getKeyword().isEmpty()) {
            categories = categoryRepository.findByNameContainingIgnoreCase(request.getKeyword(), pageable);
        } else if (request.getIsActive() != null && request.getIsActive()) {
            categories = categoryRepository.findByIsActiveTrue(pageable);
        } else {
            categories = categoryRepository.findAll(pageable);
        }

        return categories.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllActiveCategories() {
        return categoryRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryStatsDTO getCategoryStats(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));

        List<Product> products = productRepository.findByCategoryId(id, PageRequest.of(0, Integer.MAX_VALUE)).getContent();

        long totalProducts = products.size();
        long activeProducts = products.stream().filter(Product::getIsActive).count();
        long lowStockProducts = products.stream().filter(p -> p.getStockQuantity() <= p.getReorderLevel()).count();

        BigDecimal totalStockValue = products.stream()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averagePrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(totalProducts > 0 ? BigDecimal.valueOf(totalProducts) : BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);

        return CategoryStatsDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .totalProducts(totalProducts)
                .activeProducts(activeProducts)
                .lowStockProducts(lowStockProducts)
                .totalStockValue(totalStockValue)
                .averagePrice(averagePrice)
                .build();
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public void deactivateCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        category.setIsActive(false);
        categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getCategoryProducts(Long categoryId) {
        return productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getCategoryActiveProducts(Long categoryId) {
        return productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .filter(Product::getIsActive)
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getCategoryLowStockProducts(Long categoryId) {
        return productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .filter(p -> p.getStockQuantity() <= p.getReorderLevel())
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Long getCategoryProductCount(Long categoryId) {
        return (long) productRepository.findByCategoryId(categoryId, PageRequest.of(0, Integer.MAX_VALUE)).getContent().size();
    }

    private CategoryDTO mapToDTO(Category category) {
        long productCount = category.getProducts() != null ? category.getProducts().size() : 0;

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .isActive(category.getIsActive())
                .productCount(productCount)
                .build();
    }

    private ProductDTO mapProductToDTO(Product product) {
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
}
