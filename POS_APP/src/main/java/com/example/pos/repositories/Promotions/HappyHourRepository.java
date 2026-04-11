package com.example.pos.repositories.Promotions;

import com.example.pos.entities.Promotions.HappyHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for HappyHour.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface HappyHourRepository extends JpaRepository<HappyHour, Long> {

    /**
     * Get all records (API usage).
     */
    default List<HappyHour> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<HappyHour> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<HappyHour> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default HappyHour create(HappyHour entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default HappyHour update(HappyHour entity) {
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
