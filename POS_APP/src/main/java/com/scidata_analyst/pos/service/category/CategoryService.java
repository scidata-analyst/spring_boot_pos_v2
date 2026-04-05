package com.scidata_analyst.pos.service.category;

import com.scidata_analyst.pos.dto.category.CategoryDTO;
import com.scidata_analyst.pos.dto.category.CategoryStatsDTO;
import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.request.category.CreateCategoryRequest;
import com.scidata_analyst.pos.request.category.SearchCategoryRequest;
import com.scidata_analyst.pos.request.category.UpdateCategoryRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CreateCategoryRequest request);

    CategoryDTO updateCategory(Long id, UpdateCategoryRequest request);

    CategoryDTO getCategoryById(Long id);

    CategoryDTO getCategoryByName(String name);

    Page<CategoryDTO> searchCategories(SearchCategoryRequest request);

    List<CategoryDTO> getAllActiveCategories();

    CategoryStatsDTO getCategoryStats(Long id);

    void deleteCategory(Long id);

    void deactivateCategory(Long id);

    boolean existsByName(String name);

    List<ProductDTO> getCategoryProducts(Long categoryId);

    List<ProductDTO> getCategoryActiveProducts(Long categoryId);

    List<ProductDTO> getCategoryLowStockProducts(Long categoryId);

    Long getCategoryProductCount(Long categoryId);
}
