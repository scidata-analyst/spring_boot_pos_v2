package com.example.pos.repositories.Loyalty;

import com.example.pos.entities.Loyalty.PointsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for PointsConfig entity.
 * <p>
 * Provides full CRUD operations for PointsConfig using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface PointsConfigRepository extends JpaRepository<PointsConfig, Long> {

    /**
     * Retrieve all PointsConfig records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of PointsConfig
     */
    default List<PointsConfig> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single PointsConfig by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the PointsConfig
     * @return Optional containing PointsConfig if found
     */
    default Optional<PointsConfig> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a PointsConfig.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved PointsConfig
     */
    default PointsConfig saveEntity(PointsConfig entity) {
        return save(entity);
    }

    /**
     * Delete a PointsConfig by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
