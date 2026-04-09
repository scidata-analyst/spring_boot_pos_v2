package com.example.pos.repositories.Products;

import com.example.pos.entities.Products.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for StockMovement entity.
 * <p>
 * Provides full CRUD operations for StockMovement using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    /**
     * Retrieve all StockMovement records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of StockMovement
     */
    default List<StockMovement> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single StockMovement by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the StockMovement
     * @return Optional containing StockMovement if found
     */
    default Optional<StockMovement> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a StockMovement.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved StockMovement
     */
    default StockMovement saveEntity(StockMovement entity) {
        return save(entity);
    }

    /**
     * Delete a StockMovement by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
