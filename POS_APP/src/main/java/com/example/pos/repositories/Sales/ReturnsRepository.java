package com.example.pos.repositories.Sales;

import com.example.pos.entities.Sales.Returns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Returns entity.
 * <p>
 * Provides full CRUD operations for Returns using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface ReturnsRepository extends JpaRepository<Returns, Long> {

    /**
     * Retrieve all Returns records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Returns
     */
    default List<Returns> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Returns by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Returns
     * @return Optional containing Returns if found
     */
    default Optional<Returns> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Returns.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Returns
     */
    default Returns saveEntity(Returns entity) {
        return save(entity);
    }

    /**
     * Delete a Returns by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
