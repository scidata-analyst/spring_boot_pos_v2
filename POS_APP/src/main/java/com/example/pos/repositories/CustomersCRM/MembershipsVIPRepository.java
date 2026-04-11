package com.example.pos.repositories.CustomersCRM;

import com.example.pos.entities.CustomersCRM.MembershipsVIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for MembershipsVIP.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface MembershipsVIPRepository extends JpaRepository<MembershipsVIP, Long> {

    /**
     * Get all records (API usage).
     */
    default List<MembershipsVIP> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<MembershipsVIP> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<MembershipsVIP> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default MembershipsVIP create(MembershipsVIP entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default MembershipsVIP update(MembershipsVIP entity) {
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
