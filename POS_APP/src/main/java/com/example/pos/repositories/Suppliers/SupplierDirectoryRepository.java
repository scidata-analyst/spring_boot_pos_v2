package com.example.pos.repositories.Suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pos.entities.Suppliers.SupplierDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for SupplierDirectory.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface SupplierDirectoryRepository extends JpaRepository<SupplierDirectory, Long> {

    /**
     * Get all records (API usage).
     */
    default List<SupplierDirectory> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default Page<SupplierDirectory> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM SupplierDirectory e WHERE "
           + "LOWER(e.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.contactPerson) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.email) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.phone) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.address) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<SupplierDirectory> searchAll(@Param("search") String search, Pageable pageable);

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<SupplierDirectory> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default SupplierDirectory create(SupplierDirectory entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default SupplierDirectory update(SupplierDirectory entity) {
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
