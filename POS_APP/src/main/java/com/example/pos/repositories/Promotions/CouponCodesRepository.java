package com.example.pos.repositories.Promotions;

import com.example.pos.entities.Promotions.CouponCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CouponCodes.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CouponCodesRepository extends JpaRepository<CouponCodes, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CouponCodes> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<CouponCodes> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CouponCodes> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CouponCodes create(CouponCodes entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CouponCodes update(CouponCodes entity) {
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
