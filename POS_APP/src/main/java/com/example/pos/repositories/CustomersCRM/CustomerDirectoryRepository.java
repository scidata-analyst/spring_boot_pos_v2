package com.example.pos.repositories.CustomersCRM;

import com.example.pos.entities.CustomersCRM.CustomerDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CustomerDirectory.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CustomerDirectoryRepository extends JpaRepository<CustomerDirectory, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CustomerDirectory> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<CustomerDirectory> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CustomerDirectory> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CustomerDirectory create(CustomerDirectory entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CustomerDirectory update(CustomerDirectory entity) {
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
