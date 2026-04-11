package com.example.pos.repositories.SalesBilling;

import com.example.pos.entities.SalesBilling.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Transactions.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    /**
     * Get all records (API usage).
     */
    default List<Transactions> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<Transactions> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<Transactions> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default Transactions create(Transactions entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default Transactions update(Transactions entity) {
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
