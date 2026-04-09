package com.example.pos.repositories.Promos;

import com.example.pos.entities.Promos.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Coupons entity.
 * <p>
 * Provides full CRUD operations for Coupons using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long> {

    /**
     * Retrieve all Coupons records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Coupons
     */
    default List<Coupons> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Coupons by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Coupons
     * @return Optional containing Coupons if found
     */
    default Optional<Coupons> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Coupons.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Coupons
     */
    default Coupons saveEntity(Coupons entity) {
        return save(entity);
    }

    /**
     * Delete a Coupons by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
