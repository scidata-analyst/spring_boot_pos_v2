package com.example.pos.repositories.Suppliers;

import com.example.pos.entities.Suppliers.SupplierPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for SupplierPayments entity.
 * <p>
 * Provides full CRUD operations for SupplierPayments using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface SupplierPaymentsRepository extends JpaRepository<SupplierPayments, Long> {

    /**
     * Retrieve all SupplierPayments records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of SupplierPayments
     */
    default List<SupplierPayments> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single SupplierPayments by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the SupplierPayments
     * @return Optional containing SupplierPayments if found
     */
    default Optional<SupplierPayments> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a SupplierPayments.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved SupplierPayments
     */
    default SupplierPayments saveEntity(SupplierPayments entity) {
        return save(entity);
    }

    /**
     * Delete a SupplierPayments by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
