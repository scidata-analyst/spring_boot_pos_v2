package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.SupplierPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for SupplierPayments.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface SupplierPaymentsRepository extends JpaRepository<SupplierPayments, Long> {

    /**
     * Get all records (API usage).
     */
    default List<SupplierPayments> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<SupplierPayments> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<SupplierPayments> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default SupplierPayments create(SupplierPayments entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default SupplierPayments update(SupplierPayments entity) {
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
