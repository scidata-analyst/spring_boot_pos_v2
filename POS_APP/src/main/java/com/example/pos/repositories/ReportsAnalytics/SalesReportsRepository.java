package com.example.pos.repositories.ReportsAnalytics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.ReportsAnalytics.SalesReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for SalesReports.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface SalesReportsRepository extends JpaRepository<SalesReports, Long> {

    /**
     * Get all records (API usage).
     */
    default List<SalesReports> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<SalesReports> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM SalesReports e WHERE "
           + "LOWER(e.reportType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.period) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<SalesReports> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<SalesReports> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default SalesReports create(SalesReports entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default SalesReports update(SalesReports entity) {
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
