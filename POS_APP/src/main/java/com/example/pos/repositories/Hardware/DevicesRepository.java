package com.example.pos.repositories.Hardware;

import com.example.pos.entities.Hardware.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Devices entity.
 * <p>
 * Provides full CRUD operations for Devices using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface DevicesRepository extends JpaRepository<Devices, Long> {

    /**
     * Retrieve all Devices records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Devices
     */
    default List<Devices> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Devices by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Devices
     * @return Optional containing Devices if found
     */
    default Optional<Devices> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Devices.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Devices
     */
    default Devices saveEntity(Devices entity) {
        return save(entity);
    }

    /**
     * Delete a Devices by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
