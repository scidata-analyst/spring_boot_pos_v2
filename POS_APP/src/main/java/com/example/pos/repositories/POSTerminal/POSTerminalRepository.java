package com.example.pos.repositories.POSTerminal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.POSTerminal.POSTerminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for POSTerminal.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface POSTerminalRepository extends JpaRepository<POSTerminal, Long> {

    /**
     * Get all records (API usage).
     */
    default List<POSTerminal> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<POSTerminal> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM POSTerminal e WHERE "
           + "LOWER(e.terminalName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.terminalCode) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<POSTerminal> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<POSTerminal> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default POSTerminal create(POSTerminal entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default POSTerminal update(POSTerminal entity) {
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
