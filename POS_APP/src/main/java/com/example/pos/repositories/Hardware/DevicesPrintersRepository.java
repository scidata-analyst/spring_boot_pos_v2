package com.example.pos.repositories.Hardware;

import com.example.pos.entities.Hardware.DevicesPrinters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for DevicesPrinters.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface DevicesPrintersRepository extends JpaRepository<DevicesPrinters, Long> {

    /**
     * Get all records (API usage).
     */
    default List<DevicesPrinters> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<DevicesPrinters> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<DevicesPrinters> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default DevicesPrinters create(DevicesPrinters entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default DevicesPrinters update(DevicesPrinters entity) {
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
