package com.example.pos.repositories.Promotions;

import com.example.pos.entities.Promotions.OffersCombos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for OffersCombos.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface OffersCombosRepository extends JpaRepository<OffersCombos, Long> {

    /**
     * Get all records (API usage).
     */
    default List<OffersCombos> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<OffersCombos> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<OffersCombos> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default OffersCombos create(OffersCombos entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default OffersCombos update(OffersCombos entity) {
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
