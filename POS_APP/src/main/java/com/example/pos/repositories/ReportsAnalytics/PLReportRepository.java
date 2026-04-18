package com.example.pos.repositories.ReportsAnalytics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.ReportsAnalytics.PLReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for PLReport.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface PLReportRepository extends JpaRepository<PLReport, Long> {

    /**
     * Get all records (API usage).
     */
    default List<PLReport> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<PLReport> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM PLReport e WHERE "
           + "LOWER(e.reportType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.period) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<PLReport> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<PLReport> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default PLReport create(PLReport entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default PLReport update(PLReport entity) {
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
