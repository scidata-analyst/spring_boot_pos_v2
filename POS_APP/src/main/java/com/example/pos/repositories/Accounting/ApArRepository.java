package com.example.pos.repositories.Accounting;

import com.example.pos.entities.Accounting.ApAr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for ApAr entity.
 * <p>
 * Provides full CRUD operations for ApAr using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface ApArRepository extends JpaRepository<ApAr, Long> {

    /**
     * Retrieve all ApAr records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of ApAr
     */
    default List<ApAr> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single ApAr by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the ApAr
     * @return Optional containing ApAr if found
     */
    default Optional<ApAr> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a ApAr.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved ApAr
     */
    default ApAr saveEntity(ApAr entity) {
        return save(entity);
    }

    /**
     * Delete a ApAr by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
