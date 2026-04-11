package com.example.pos.repositories.SalesBilling;

import com.example.pos.entities.SalesBilling.HeldOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for HeldOrders.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface HeldOrdersRepository extends JpaRepository<HeldOrders, Long> {

    /**
     * Get all records (API usage).
     */
    default List<HeldOrders> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<HeldOrders> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<HeldOrders> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default HeldOrders create(HeldOrders entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default HeldOrders update(HeldOrders entity) {
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
