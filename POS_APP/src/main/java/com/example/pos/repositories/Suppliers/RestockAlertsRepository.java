package com.example.pos.repositories.Suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    default Page<RestockAlerts> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM RestockAlerts e WHERE "
           + "LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<RestockAlerts> searchAll(@Param("search") String search, Pageable pageable);

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
