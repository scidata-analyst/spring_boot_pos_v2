package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Suppliers entity.
 * <p>
 * Provides full CRUD operations for Suppliers using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {

    /**
     * Retrieve all Suppliers records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Suppliers
     */
    default List<Suppliers> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Suppliers by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Suppliers
     * @return Optional containing Suppliers if found
     */
    default Optional<Suppliers> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Suppliers.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Suppliers
     */
    default Suppliers saveEntity(Suppliers entity) {
        return save(entity);
    }

    /**
     * Delete a Suppliers by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
