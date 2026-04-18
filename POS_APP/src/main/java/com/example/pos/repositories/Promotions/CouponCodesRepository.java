package com.example.pos.repositories.Promotions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    default Page<CouponCodes> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM CouponCodes e WHERE "
           + "LOWER(e.code) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.discountType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<CouponCodes> searchAll(@Param("search") String search, Pageable pageable);

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
