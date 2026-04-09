package com.example.pos.repositories.Customers;

import com.example.pos.entities.Customers.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Customers entity.
 * <p>
 * Provides full CRUD operations for Customers using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    /**
     * Retrieve all Customers records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Customers
     */
    default List<Customers> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Customers by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Customers
     * @return Optional containing Customers if found
     */
    default Optional<Customers> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Customers.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Customers
     */
    default Customers saveEntity(Customers entity) {
        return save(entity);
    }

    /**
     * Delete a Customers by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
