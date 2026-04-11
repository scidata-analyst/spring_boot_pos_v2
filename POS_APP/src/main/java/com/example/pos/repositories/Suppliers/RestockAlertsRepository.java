package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.RestockAlerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for RestockAlerts.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface RestockAlertsRepository extends JpaRepository<RestockAlerts, Long> {

    /**
     * Get all records (API usage).
     */
    default List<RestockAlerts> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<RestockAlerts> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<RestockAlerts> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default RestockAlerts create(RestockAlerts entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default RestockAlerts update(RestockAlerts entity) {
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
