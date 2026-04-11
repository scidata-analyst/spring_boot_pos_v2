package com.example.pos.repositories.CustomersCRM;

import com.example.pos.entities.CustomersCRM.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for PurchaseHistory.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    /**
     * Get all records (API usage).
     */
    default List<PurchaseHistory> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<PurchaseHistory> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<PurchaseHistory> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default PurchaseHistory create(PurchaseHistory entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default PurchaseHistory update(PurchaseHistory entity) {
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
