package com.example.pos.repositories.Reports;

import com.example.pos.entities.Reports.CustomReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for CustomReport entity.
 * <p>
 * Provides full CRUD operations for CustomReport using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CustomReportRepository extends JpaRepository<CustomReport, Long> {

    /**
     * Retrieve all CustomReport records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of CustomReport
     */
    default List<CustomReport> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single CustomReport by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the CustomReport
     * @return Optional containing CustomReport if found
     */
    default Optional<CustomReport> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a CustomReport.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved CustomReport
     */
    default CustomReport saveEntity(CustomReport entity) {
        return save(entity);
    }

    /**
     * Delete a CustomReport by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
