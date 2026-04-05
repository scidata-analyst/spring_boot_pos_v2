package com.scidata_analyst.pos.repository.product;

import com.scidata_analyst.pos.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByBarcode(String barcode);

    boolean existsByBarcode(String barcode);

    Page<Product> findByIsActiveTrue(Pageable pageable);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

    Page<Product> findBySupplierId(Long supplierId, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE " +
           "(:keyword IS NULL OR p.name LIKE %:keyword% OR p.barcode LIKE %:keyword%) AND " +
           "(:categoryId IS NULL OR p.category.id = :categoryId) AND " +
           "(:supplierId IS NULL OR p.supplier.id = :supplierId) AND " +
           "(:isActive IS NULL OR p.isActive = :isActive) AND " +
           "(:minStock IS NULL OR p.stockQuantity >= :minStock)")
    Page<Product> searchProducts(@Param("keyword") String keyword,
                                 @Param("categoryId") Long categoryId,
                                 @Param("supplierId") Long supplierId,
                                 @Param("isActive") Boolean isActive,
                                 @Param("minStock") Integer minStock,
                                 Pageable pageable);

    List<Product> findByStockQuantityLessThanEqual(Integer threshold);

    @Query("SELECT p FROM Product p WHERE p.stockQuantity <= p.reorderLevel AND p.isActive = true")
    List<Product> findLowStockProducts();
}
