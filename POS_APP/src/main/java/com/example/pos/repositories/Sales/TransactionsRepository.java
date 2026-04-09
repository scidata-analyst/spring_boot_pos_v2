package com.example.pos.repositories.Sales;

import com.example.pos.entities.Sales.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Transactions entity.
 * <p>
 * Provides full CRUD operations for Transactions using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    /**
     * Retrieve all Transactions records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Transactions
     */
    default List<Transactions> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Transactions by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Transactions
     * @return Optional containing Transactions if found
     */
    default Optional<Transactions> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Transactions.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Transactions
     */
    default Transactions saveEntity(Transactions entity) {
        return save(entity);
    }

    /**
     * Delete a Transactions by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
