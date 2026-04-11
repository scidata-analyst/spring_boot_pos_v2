package com.example.pos.repositories.PaymentAccounting;

import com.example.pos.entities.PaymentAccounting.TaxReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for TaxReports.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface TaxReportsRepository extends JpaRepository<TaxReports, Long> {

    /**
     * Get all records (API usage).
     */
    default List<TaxReports> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<TaxReports> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<TaxReports> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default TaxReports create(TaxReports entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default TaxReports update(TaxReports entity) {
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
