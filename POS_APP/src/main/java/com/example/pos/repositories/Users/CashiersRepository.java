package com.example.pos.repositories.Users;

import com.example.pos.entities.Users.Cashiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Cashiers entity.
 * <p>
 * Provides full CRUD operations for Cashiers using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CashiersRepository extends JpaRepository<Cashiers, Long> {

    /**
     * Retrieve all Cashiers records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Cashiers
     */
    default List<Cashiers> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Cashiers by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Cashiers
     * @return Optional containing Cashiers if found
     */
    default Optional<Cashiers> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Cashiers.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Cashiers
     */
    default Cashiers saveEntity(Cashiers entity) {
        return save(entity);
    }

    /**
     * Delete a Cashiers by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
