package com.example.pos.repositories.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Products.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for StockMovement.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    /**
     * Get all records (API usage).
     */
    default List<StockMovement> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<StockMovement> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM StockMovement e WHERE "
           + "LOWER(e.type) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.reason) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<StockMovement> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<StockMovement> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default StockMovement create(StockMovement entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default StockMovement update(StockMovement entity) {
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
