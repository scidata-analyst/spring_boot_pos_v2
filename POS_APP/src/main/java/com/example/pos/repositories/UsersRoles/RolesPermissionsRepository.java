package com.example.pos.repositories.UsersRoles;

import com.example.pos.entities.UsersRoles.RolesPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for RolesPermissions.
 * Supports both API and UI-friendly data access methods.
 */
@Repository
public interface RolesPermissionsRepository extends JpaRepository<RolesPermissions, Long> {

    /**
     * Get all records (API usage).
     */
    default List<RolesPermissions> all() {
        return findAll();
    }

    /**
     * Get list for index page (UI summary data).
     * Same as all() but kept for UI semantic separation.
     */
    default List<RolesPermissions> index() {
        return findAll();
    }

    /**
     * View single record by ID (UI detail page).
     */
    default Optional<RolesPermissions> view(Long id) {
        return findById(id);
    }

    /**
     * Create new entity.
     */
    default RolesPermissions create(RolesPermissions entity) {
        return save(entity);
    }

    /**
     * Update existing entity.
     */
    default RolesPermissions update(RolesPermissions entity) {
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
