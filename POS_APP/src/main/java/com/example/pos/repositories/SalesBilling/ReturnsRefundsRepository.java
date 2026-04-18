package com.example.pos.repositories.SalesBilling;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.SalesBilling.ReturnsRefunds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for ReturnsRefunds.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface ReturnsRefundsRepository extends JpaRepository<ReturnsRefunds, Long> {

    /**
     * Get all records (API usage).
     */
    default List<ReturnsRefunds> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<ReturnsRefunds> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM ReturnsRefunds e WHERE "
           + "LOWER(e.reason) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ReturnsRefunds> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<ReturnsRefunds> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default ReturnsRefunds create(ReturnsRefunds entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default ReturnsRefunds update(ReturnsRefunds entity) {
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
