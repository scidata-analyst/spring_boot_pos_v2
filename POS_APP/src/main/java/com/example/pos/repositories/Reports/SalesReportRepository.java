package com.example.pos.repositories.Reports;

import com.example.pos.entities.Reports.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for SalesReport entity.
 * <p>
 * Provides full CRUD operations for SalesReport using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {

    /**
     * Retrieve all SalesReport records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of SalesReport
     */
    default List<SalesReport> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single SalesReport by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the SalesReport
     * @return Optional containing SalesReport if found
     */
    default Optional<SalesReport> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a SalesReport.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved SalesReport
     */
    default SalesReport saveEntity(SalesReport entity) {
        return save(entity);
    }

    /**
     * Delete a SalesReport by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
