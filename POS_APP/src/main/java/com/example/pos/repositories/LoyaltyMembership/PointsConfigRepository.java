package com.example.pos.repositories.LoyaltyMembership;

import com.example.pos.entities.LoyaltyMembership.PointsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for PointsConfig.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface PointsConfigRepository extends JpaRepository<PointsConfig, Long> {

    /**
     * Get all records (API usage).
     */
    default List<PointsConfig> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<PointsConfig> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<PointsConfig> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default PointsConfig create(PointsConfig entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default PointsConfig update(PointsConfig entity) {
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
