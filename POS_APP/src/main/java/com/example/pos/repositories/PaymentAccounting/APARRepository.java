package com.example.pos.repositories.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.APAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for APAR.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface APARRepository extends JpaRepository<APAR, Long> {

    /**
     * Get all records (API usage).
     */
    default List<APAR> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<APAR> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<APAR> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default APAR create(APAR entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default APAR update(APAR entity) {
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
