package com.example.pos.repositories.ReportsAnalytics;

import com.example.pos.entities.ReportsAnalytics.CustomBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CustomBuilder.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CustomBuilderRepository extends JpaRepository<CustomBuilder, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CustomBuilder> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<CustomBuilder> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CustomBuilder> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CustomBuilder create(CustomBuilder entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CustomBuilder update(CustomBuilder entity) {
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
