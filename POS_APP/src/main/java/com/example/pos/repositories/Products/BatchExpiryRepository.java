package com.example.pos.repositories.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Products.BatchExpiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for BatchExpiry.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface BatchExpiryRepository extends JpaRepository<BatchExpiry, Long> {

    /**
     * Get all records (API usage).
     */
    default List<BatchExpiry> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<BatchExpiry> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM BatchExpiry e WHERE "
           + "LOWER(e.batchNumber) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<BatchExpiry> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<BatchExpiry> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default BatchExpiry create(BatchExpiry entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default BatchExpiry update(BatchExpiry entity) {
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
