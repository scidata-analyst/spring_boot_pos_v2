package com.example.pos.repositories.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Products.BarcodeSKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for BarcodeSKU.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface BarcodeSKURepository extends JpaRepository<BarcodeSKU, Long> {

    /**
     * Get all records (API usage).
     */
    default List<BarcodeSKU> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<BarcodeSKU> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM BarcodeSKU e WHERE "
           + "LOWER(e.barcode) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.sku) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.variant) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<BarcodeSKU> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<BarcodeSKU> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default BarcodeSKU create(BarcodeSKU entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default BarcodeSKU update(BarcodeSKU entity) {
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
