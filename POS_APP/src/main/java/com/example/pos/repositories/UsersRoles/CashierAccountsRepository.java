package com.example.pos.repositories.UsersRoles;

import com.example.pos.entities.UsersRoles.CashierAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CashierAccounts.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CashierAccountsRepository extends JpaRepository<CashierAccounts, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CashierAccounts> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<CashierAccounts> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CashierAccounts> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CashierAccounts create(CashierAccounts entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CashierAccounts update(CashierAccounts entity) {
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
