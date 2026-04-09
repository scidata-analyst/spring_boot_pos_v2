package com.example.pos.repositories.Loyalty;

import com.example.pos.entities.Loyalty.Retention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Retention entity.
 * <p>
 * Provides full CRUD operations for Retention using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface RetentionRepository extends JpaRepository<Retention, Long> {

    /**
     * Retrieve all Retention records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Retention
     */
    default List<Retention> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Retention by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Retention
     * @return Optional containing Retention if found
     */
    default Optional<Retention> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Retention.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Retention
     */
    default Retention saveEntity(Retention entity) {
        return save(entity);
    }

    /**
     * Delete a Retention by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
