package com.scidata_analyst.pos.controller.category;

import com.scidata_analyst.pos.dto.category.CategoryDTO;
import com.scidata_analyst.pos.dto.category.CategoryStatsDTO;
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
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    @Override
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CreateCategoryRequest request) {
        CategoryDTO created = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequest request) {
        CategoryDTO updated = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> searchCategories(SearchCategoryRequest request) {
        Page<CategoryDTO> categories = categoryService.searchCategories(request);
        return ResponseEntity.ok(categories);
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<CategoryDTO>> getAllActiveCategories() {
        List<CategoryDTO> categories = categoryService.getAllActiveCategories();
        return ResponseEntity.ok(categories);
    }

    @Override
    @GetMapping("/{id}/stats")
    public ResponseEntity<CategoryStatsDTO> getCategoryStats(@PathVariable Long id) {
        CategoryStatsDTO stats = categoryService.getCategoryStats(id);
        return ResponseEntity.ok(stats);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCategory(@PathVariable Long id) {
        categoryService.deactivateCategory(id);
        return ResponseEntity.noContent().build();
    }
}
