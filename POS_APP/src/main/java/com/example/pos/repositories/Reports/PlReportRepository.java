package com.example.pos.repositories.Reports;

import com.example.pos.entities.Reports.PlReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for PlReport entity.
 * <p>
 * Provides full CRUD operations for PlReport using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface PlReportRepository extends JpaRepository<PlReport, Long> {

    /**
     * Retrieve all PlReport records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of PlReport
     */
    default List<PlReport> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single PlReport by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the PlReport
     * @return Optional containing PlReport if found
     */
    default Optional<PlReport> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a PlReport.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved PlReport
     */
    default PlReport saveEntity(PlReport entity) {
        return save(entity);
    }

    /**
     * Delete a PlReport by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
