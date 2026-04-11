package com.example.pos.repositories.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.Reconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Reconciliation.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface ReconciliationRepository extends JpaRepository<Reconciliation, Long> {

    /**
     * Get all records (API usage).
     */
    default List<Reconciliation> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<Reconciliation> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<Reconciliation> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default Reconciliation create(Reconciliation entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default Reconciliation update(Reconciliation entity) {
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
