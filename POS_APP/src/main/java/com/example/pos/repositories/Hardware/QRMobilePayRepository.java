package com.example.pos.repositories.Hardware;

import com.example.pos.entities.Hardware.QRMobilePay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for QRMobilePay.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface QRMobilePayRepository extends JpaRepository<QRMobilePay, Long> {

    /**
     * Get all records (API usage).
     */
    default List<QRMobilePay> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<QRMobilePay> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<QRMobilePay> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default QRMobilePay create(QRMobilePay entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default QRMobilePay update(QRMobilePay entity) {
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
