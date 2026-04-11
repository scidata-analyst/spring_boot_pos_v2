package com.example.pos.repositories.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.RetentionTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for RetentionTracking.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface RetentionTrackingRepository extends JpaRepository<RetentionTracking, Long> {

    /**
     * Get all records (API usage).
     */
    default List<RetentionTracking> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<RetentionTracking> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<RetentionTracking> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default RetentionTracking create(RetentionTracking entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default RetentionTracking update(RetentionTracking entity) {
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
