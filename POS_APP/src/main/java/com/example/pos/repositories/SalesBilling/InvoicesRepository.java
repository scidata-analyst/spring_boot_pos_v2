package com.example.pos.repositories.SalesBilling;

import com.example.pos.entities.SalesBilling.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Invoices.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {

    /**
     * Get all records (API usage).
     */
    default List<Invoices> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<Invoices> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<Invoices> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default Invoices create(Invoices entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default Invoices update(Invoices entity) {
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
