package com.example.pos.repositories.ReportsAnalytics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.ReportsAnalytics.StockReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for StockReports.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface StockReportsRepository extends JpaRepository<StockReports, Long> {

    /**
     * Get all records (API usage).
     */
    default List<StockReports> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<StockReports> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM StockReports e WHERE "
           + "LOWER(e.reportType) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<StockReports> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<StockReports> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default StockReports create(StockReports entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default StockReports update(StockReports entity) {
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
