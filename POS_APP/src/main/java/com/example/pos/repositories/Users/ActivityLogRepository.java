package com.example.pos.repositories.Users;

import com.example.pos.entities.Users.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for ActivityLog entity.
 * <p>
 * Provides full CRUD operations for ActivityLog using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    /**
     * Retrieve all ActivityLog records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of ActivityLog
     */
    default List<ActivityLog> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single ActivityLog by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the ActivityLog
     * @return Optional containing ActivityLog if found
     */
    default Optional<ActivityLog> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a ActivityLog.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved ActivityLog
     */
    default ActivityLog saveEntity(ActivityLog entity) {
        return save(entity);
    }

    /**
     * Delete a ActivityLog by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
