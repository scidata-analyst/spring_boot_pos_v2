package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.PurchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for PurchaseOrders entity.
 * <p>
 * Provides full CRUD operations for PurchaseOrders using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrders, Long> {

    /**
     * Retrieve all PurchaseOrders records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of PurchaseOrders
     */
    default List<PurchaseOrders> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single PurchaseOrders by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the PurchaseOrders
     * @return Optional containing PurchaseOrders if found
     */
    default Optional<PurchaseOrders> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a PurchaseOrders.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved PurchaseOrders
     */
    default PurchaseOrders saveEntity(PurchaseOrders entity) {
        return save(entity);
    }

    /**
     * Delete a PurchaseOrders by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
