package com.example.pos.repositories.Products;

import com.example.pos.entities.Products.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Categories entity.
 * <p>
 * Provides full CRUD operations for Categories using JpaRepository.
 * Method names are aligned with Controller and Service:
 * getAll(), get(Long id), create(), update(), delete().
 * JpaRepository handles create, update, and delete by default.
 * Custom queries can be added here following the same naming convention.
 */
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    /**
     * Retrieve all Categories records.
     * Corresponds to getAll() in Controller/Service.
     * @return List of Categories
     */
    default List<Categories> getAll() {
        return findAll();
    }

    /**
     * Retrieve a single Categories by its ID.
     * Corresponds to get(Long id) in Controller/Service.
     * @param id ID of the Categories
     * @return Optional containing Categories if found
     */
    default Optional<Categories> get(Long id) {
        return findById(id);
    }

    /**
     * Save or update a Categories.
     * Corresponds to create() or update() in Controller/Service.
     * @param entity Entity object to save
     * @return Saved Categories
     */
    default Categories saveEntity(Categories entity) {
        return save(entity);
    }

    /**
     * Delete a Categories by ID.
     * Corresponds to delete() in Controller/Service.
     * @param id ID of the entity to delete
     */
    default void deleteEntity(Long id) {
        deleteById(id);
    }

    // TODO: Add more custom query methods as needed
}
