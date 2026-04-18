package com.example.pos.repositories.Dashboard;

import com.example.pos.entities.Dashboard.Dashboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Dashboard.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

    /**
     * Get all records (API usage).
     */
    default List<Dashboard> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<Dashboard> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM Dashboard e WHERE "
           + "LOWER(e.widgetType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.title) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.dataSource) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Dashboard> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<Dashboard> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default Dashboard create(Dashboard entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default Dashboard update(Dashboard entity) {
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
