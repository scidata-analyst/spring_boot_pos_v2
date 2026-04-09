package com.example.pos.repositories.Promos;

import com.example.pos.entities.Promos.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Offers entity.
 * <p>
 * Provides full CRUD operations for Offers using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface OffersRepository extends JpaRepository<Offers, Long> {

    /**
     * Retrieve all Offers records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Offers
     */
    default List<Offers> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Offers by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Offers
     * @return Optional containing Offers if found
     */
    default Optional<Offers> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Offers.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Offers
     */
    default Offers saveEntity(Offers entity) {
        return save(entity);
    }

    /**
     * Delete a Offers by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
