package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.RestockAlerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for RestockAlerts entity.
 * <p>
 * Provides full CRUD operations for RestockAlerts using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface RestockAlertsRepository extends JpaRepository<RestockAlerts, Long> {

    /**
     * Retrieve all RestockAlerts records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of RestockAlerts
     */
    default List<RestockAlerts> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single RestockAlerts by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the RestockAlerts
     * @return Optional containing RestockAlerts if found
     */
    default Optional<RestockAlerts> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a RestockAlerts.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved RestockAlerts
     */
    default RestockAlerts saveEntity(RestockAlerts entity) {
        return save(entity);
    }

    /**
     * Delete a RestockAlerts by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
