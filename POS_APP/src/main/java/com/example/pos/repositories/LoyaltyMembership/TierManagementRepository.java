package com.example.pos.repositories.LoyaltyMembership;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.LoyaltyMembership.TierManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for TierManagement.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface TierManagementRepository extends JpaRepository<TierManagement, Long> {

    /**
     * Get all records (API usage).
     */
    default List<TierManagement> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<TierManagement> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM TierManagement e WHERE "
           + "LOWER(e.tierName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<TierManagement> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<TierManagement> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default TierManagement create(TierManagement entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default TierManagement update(TierManagement entity) {
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
