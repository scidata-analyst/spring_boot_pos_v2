package com.example.pos.repositories.Hardware;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    default Page<DevicesPrinters> index(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return searchAll(search, pageable);
        }
        return findAll(pageable);
    }

    @Query("SELECT e FROM DevicesPrinters e WHERE "
           + "LOWER(e.deviceName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.deviceType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.connectionType) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.ipAddress) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<DevicesPrinters> searchAll(@Param("search") String search, Pageable pageable);

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
