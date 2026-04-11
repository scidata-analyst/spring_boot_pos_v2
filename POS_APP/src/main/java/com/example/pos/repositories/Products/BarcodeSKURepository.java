package com.example.pos.repositories.Products;

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
    default List<BarcodeSKU> index() {
        return findAll();
    }

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
