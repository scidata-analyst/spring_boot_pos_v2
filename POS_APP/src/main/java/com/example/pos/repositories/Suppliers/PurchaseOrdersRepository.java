package com.example.pos.repositories.Suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    default Page<PurchaseOrders> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM PurchaseOrders e WHERE "
           + "LOWER(e.orderNumber) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<PurchaseOrders> searchAll(@Param("search") String search, Pageable pageable);

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
