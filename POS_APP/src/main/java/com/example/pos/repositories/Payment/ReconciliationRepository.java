package com.example.pos.repositories.Payment;

import com.example.pos.entities.Payment.Reconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Reconciliation entity.
 * <p>
 * Provides full CRUD operations for Reconciliation using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface ReconciliationRepository extends JpaRepository<Reconciliation, Long> {

    /**
     * Retrieve all Reconciliation records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Reconciliation
     */
    default List<Reconciliation> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Reconciliation by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Reconciliation
     * @return Optional containing Reconciliation if found
     */
    default Optional<Reconciliation> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Reconciliation.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Reconciliation
     */
    default Reconciliation saveEntity(Reconciliation entity) {
        return save(entity);
    }

    /**
     * Delete a Reconciliation by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
