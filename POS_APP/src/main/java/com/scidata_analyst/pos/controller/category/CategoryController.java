package com.scidata_analyst.pos.controller.category;

import com.scidata_analyst.pos.dto.category.CategoryDTO;
import com.scidata_analyst.pos.dto.category.CategoryStatsDTO;
import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.request.category.CreateCategoryRequest;
import com.scidata_analyst.pos.request.category.SearchCategoryRequest;
import com.scidata_analyst.pos.request.category.UpdateCategoryRequest;
import com.scidata_analyst.pos.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CreateCategoryRequest request) {
        CategoryDTO created = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequest request) {
        CategoryDTO updated = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> searchCategories(SearchCategoryRequest request) {
        Page<CategoryDTO> categories = categoryService.searchCategories(request);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/active")
    public ResponseEntity<List<CategoryDTO>> getAllActiveCategories() {
        List<CategoryDTO> categories = categoryService.getAllActiveCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<CategoryStatsDTO> getCategoryStats(@PathVariable Long id) {
        CategoryStatsDTO stats = categoryService.getCategoryStats(id);
        return ResponseEntity.ok(stats);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCategory(@PathVariable Long id) {
        categoryService.deactivateCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductDTO>> getCategoryProducts(@PathVariable Long id) {
        List<ProductDTO> products = categoryService.getCategoryProducts(id);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/active")
    public ResponseEntity<List<ProductDTO>> getCategoryActiveProducts(@PathVariable Long id) {
        List<ProductDTO> products = categoryService.getCategoryActiveProducts(id);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/low-stock")
    public ResponseEntity<List<ProductDTO>> getCategoryLowStockProducts(@PathVariable Long id) {
        List<ProductDTO> products = categoryService.getCategoryLowStockProducts(id);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/count")
    public ResponseEntity<Long> getCategoryProductCount(@PathVariable Long id) {
        Long count = categoryService.getCategoryProductCount(id);
        return ResponseEntity.ok(count);
    }
}
