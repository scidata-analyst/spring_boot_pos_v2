package com.example.pos.repositories.Customers;

import com.example.pos.entities.Customers.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for PurchaseHistory entity.
 * <p>
 * Provides full CRUD operations for PurchaseHistory using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    /**
     * Retrieve all PurchaseHistory records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of PurchaseHistory
     */
    default List<PurchaseHistory> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single PurchaseHistory by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the PurchaseHistory
     * @return Optional containing PurchaseHistory if found
     */
    default Optional<PurchaseHistory> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a PurchaseHistory.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved PurchaseHistory
     */
    default PurchaseHistory saveEntity(PurchaseHistory entity) {
        return save(entity);
    }

    /**
     * Delete a PurchaseHistory by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
