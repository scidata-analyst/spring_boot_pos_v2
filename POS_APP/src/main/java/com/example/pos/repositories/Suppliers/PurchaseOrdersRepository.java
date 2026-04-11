package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.PurchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for PurchaseOrders.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrders, Long> {

    /**
     * Get all records (API usage).
     */
    default List<PurchaseOrders> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<PurchaseOrders> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<PurchaseOrders> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default PurchaseOrders create(PurchaseOrders entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default PurchaseOrders update(PurchaseOrders entity) {
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
