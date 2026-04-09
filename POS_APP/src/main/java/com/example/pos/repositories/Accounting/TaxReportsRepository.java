package com.example.pos.repositories.Accounting;

import com.example.pos.entities.Accounting.TaxReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for TaxReports entity.
 * <p>
 * Provides full CRUD operations for TaxReports using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface TaxReportsRepository extends JpaRepository<TaxReports, Long> {

    /**
     * Retrieve all TaxReports records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of TaxReports
     */
    default List<TaxReports> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single TaxReports by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the TaxReports
     * @return Optional containing TaxReports if found
     */
    default Optional<TaxReports> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a TaxReports.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved TaxReports
     */
    default TaxReports saveEntity(TaxReports entity) {
        return save(entity);
    }

    /**
     * Delete a TaxReports by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
