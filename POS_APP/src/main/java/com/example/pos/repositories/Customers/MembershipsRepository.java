package com.example.pos.repositories.Customers;

import com.example.pos.entities.Customers.Memberships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Memberships entity.
 * <p>
 * Provides full CRUD operations for Memberships using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface MembershipsRepository extends JpaRepository<Memberships, Long> {

    /**
     * Retrieve all Memberships records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Memberships
     */
    default List<Memberships> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Memberships by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Memberships
     * @return Optional containing Memberships if found
     */
    default Optional<Memberships> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Memberships.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Memberships
     */
    default Memberships saveEntity(Memberships entity) {
        return save(entity);
    }

    /**
     * Delete a Memberships by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
