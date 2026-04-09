package com.example.pos.repositories.Reports;

import com.example.pos.entities.Reports.StockReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for StockReport entity.
 * <p>
 * Provides full CRUD operations for StockReport using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface StockReportRepository extends JpaRepository<StockReport, Long> {

    /**
     * Retrieve all StockReport records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of StockReport
     */
    default List<StockReport> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single StockReport by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the StockReport
     * @return Optional containing StockReport if found
     */
    default Optional<StockReport> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a StockReport.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved StockReport
     */
    default StockReport saveEntity(StockReport entity) {
        return save(entity);
    }

    /**
     * Delete a StockReport by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
