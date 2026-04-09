package com.example.pos.repositories.Products;

import com.example.pos.entities.Products.Barcodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Barcodes entity.
 * <p>
 * Provides full CRUD operations for Barcodes using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface BarcodesRepository extends JpaRepository<Barcodes, Long> {

    /**
     * Retrieve all Barcodes records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Barcodes
     */
    default List<Barcodes> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Barcodes by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Barcodes
     * @return Optional containing Barcodes if found
     */
    default Optional<Barcodes> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Barcodes.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Barcodes
     */
    default Barcodes saveEntity(Barcodes entity) {
        return save(entity);
    }

    /**
     * Delete a Barcodes by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
