package com.example.pos.repositories.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Products.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Categories.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    /**
     * Get all records (API usage).
     */
    default List<Categories> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<Categories> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM Categories e WHERE "
           + "LOWER(e.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.icon) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.description) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Categories> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<Categories> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default Categories create(Categories entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default Categories update(Categories entity) {
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
