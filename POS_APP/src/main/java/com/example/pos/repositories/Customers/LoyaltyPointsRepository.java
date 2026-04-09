package com.example.pos.repositories.Customers;

import com.example.pos.entities.Customers.LoyaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for LoyaltyPoints entity.
 * <p>
 * Provides full CRUD operations for LoyaltyPoints using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints, Long> {

    /**
     * Retrieve all LoyaltyPoints records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of LoyaltyPoints
     */
    default List<LoyaltyPoints> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single LoyaltyPoints by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the LoyaltyPoints
     * @return Optional containing LoyaltyPoints if found
     */
    default Optional<LoyaltyPoints> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a LoyaltyPoints.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved LoyaltyPoints
     */
    default LoyaltyPoints saveEntity(LoyaltyPoints entity) {
        return save(entity);
    }

    /**
     * Delete a LoyaltyPoints by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
