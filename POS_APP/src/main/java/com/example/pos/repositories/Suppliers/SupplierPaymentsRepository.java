package com.example.pos.repositories.Suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    default Page<SupplierPayments> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM SupplierPayments e WHERE "
           + "LOWER(e.paymentMethod) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.referenceNumber) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<SupplierPayments> searchAll(@Param("search") String search, Pageable pageable);

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
