package com.example.pos.repositories.CustomersCRM;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.CustomersCRM.LoyaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for LoyaltyPoints.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints, Long> {

    /**
     * Get all records (API usage).
     */
    default List<LoyaltyPoints> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<LoyaltyPoints> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM LoyaltyPoints e WHERE "
           + "LOWER(e.type) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<LoyaltyPoints> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<LoyaltyPoints> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default LoyaltyPoints create(LoyaltyPoints entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default LoyaltyPoints update(LoyaltyPoints entity) {
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
