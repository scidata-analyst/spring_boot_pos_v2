package com.example.pos.repositories.Sales;

import com.example.pos.entities.Sales.HeldOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for HeldOrders entity.
 * <p>
 * Provides full CRUD operations for HeldOrders using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface HeldOrdersRepository extends JpaRepository<HeldOrders, Long> {

    /**
     * Retrieve all HeldOrders records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of HeldOrders
     */
    default List<HeldOrders> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single HeldOrders by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the HeldOrders
     * @return Optional containing HeldOrders if found
     */
    default Optional<HeldOrders> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a HeldOrders.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved HeldOrders
     */
    default HeldOrders saveEntity(HeldOrders entity) {
        return save(entity);
    }

    /**
     * Delete a HeldOrders by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
