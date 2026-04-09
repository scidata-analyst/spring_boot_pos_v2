package com.example.pos.repositories.Loyalty;

import com.example.pos.entities.Loyalty.TierManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for TierManagement entity.
 * <p>
 * Provides full CRUD operations for TierManagement using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface TierManagementRepository extends JpaRepository<TierManagement, Long> {

    /**
     * Retrieve all TierManagement records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of TierManagement
     */
    default List<TierManagement> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single TierManagement by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the TierManagement
     * @return Optional containing TierManagement if found
     */
    default Optional<TierManagement> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a TierManagement.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved TierManagement
     */
    default TierManagement saveEntity(TierManagement entity) {
        return save(entity);
    }

    /**
     * Delete a TierManagement by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
