package com.example.pos.repositories.UsersRoles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.UsersRoles.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for ActivityLog.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    /**
     * Get all records (API usage).
     */
    default List<ActivityLog> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<ActivityLog> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM ActivityLog e WHERE "
           + "LOWER(e.action) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.module) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.description) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.ipAddress) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ActivityLog> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<ActivityLog> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default ActivityLog create(ActivityLog entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default ActivityLog update(ActivityLog entity) {
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
