package com.example.pos.repositories.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Products.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for ProductCatalog.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {

    /**
     * Get all records (API usage).
     */
    default List<ProductCatalog> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<ProductCatalog> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM ProductCatalog e WHERE "
           + "LOWER(e.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.sku) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.categoryId) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.unit) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.taxRate) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ProductCatalog> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<ProductCatalog> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default ProductCatalog create(ProductCatalog entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default ProductCatalog update(ProductCatalog entity) {
        return save(entity);
    }

    /**
     * Delete entity by ID.
     */
    default void delete(Long id) {
        deleteById(id);
    }

    // =====================================
    // Custom Queries Section
    // =====================================
}
