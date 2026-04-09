package com.example.pos.repositories.Sales;

import com.example.pos.entities.Sales.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Invoices entity.
 * <p>
 * Provides full CRUD operations for Invoices using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {

    /**
     * Retrieve all Invoices records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Invoices
     */
    default List<Invoices> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Invoices by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Invoices
     * @return Optional containing Invoices if found
     */
    default Optional<Invoices> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Invoices.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Invoices
     */
    default Invoices saveEntity(Invoices entity) {
        return save(entity);
    }

    /**
     * Delete a Invoices by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
