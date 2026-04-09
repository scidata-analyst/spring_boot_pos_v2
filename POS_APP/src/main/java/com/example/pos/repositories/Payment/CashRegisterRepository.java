package com.example.pos.repositories.Payment;

import com.example.pos.entities.Payment.CashRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for CashRegister entity.
 * <p>
 * Provides full CRUD operations for CashRegister using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {

    /**
     * Retrieve all CashRegister records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of CashRegister
     */
    default List<CashRegister> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single CashRegister by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the CashRegister
     * @return Optional containing CashRegister if found
     */
    default Optional<CashRegister> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a CashRegister.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved CashRegister
     */
    default CashRegister saveEntity(CashRegister entity) {
        return save(entity);
    }

    /**
     * Delete a CashRegister by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
