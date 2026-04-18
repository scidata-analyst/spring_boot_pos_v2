package com.example.pos.repositories.PaymentAccounting;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.PaymentAccounting.CashRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for CashRegister.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {

    /**
     * Get all records (API usage).
     */
    default List<CashRegister> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<CashRegister> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM CashRegister e WHERE "
           + "LOWER(e.registerName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<CashRegister> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<CashRegister> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default CashRegister create(CashRegister entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default CashRegister update(CashRegister entity) {
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
