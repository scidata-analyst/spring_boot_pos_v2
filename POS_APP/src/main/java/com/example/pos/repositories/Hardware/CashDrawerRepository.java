package com.example.pos.repositories.Hardware;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Hardware.CashDrawer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CashDrawer.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CashDrawerRepository extends JpaRepository<CashDrawer, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CashDrawer> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<CashDrawer> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM CashDrawer e WHERE "
           + "LOWER(e.drawerNumber) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.connectedDevice) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<CashDrawer> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CashDrawer> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CashDrawer create(CashDrawer entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CashDrawer update(CashDrawer entity) {
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
