package com.example.pos.repositories.Users;

import com.example.pos.entities.Users.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Roles entity.
 * <p>
 * Provides full CRUD operations for Roles using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    /**
     * Retrieve all Roles records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Roles
     */
    default List<Roles> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Roles by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Roles
     * @return Optional containing Roles if found
     */
    default Optional<Roles> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Roles.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Roles
     */
    default Roles saveEntity(Roles entity) {
        return save(entity);
    }

    /**
     * Delete a Roles by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
