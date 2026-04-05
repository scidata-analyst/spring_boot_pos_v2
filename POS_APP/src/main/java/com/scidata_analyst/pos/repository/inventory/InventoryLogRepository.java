package com.scidata_analyst.pos.repository.inventory;

import com.scidata_analyst.pos.entity.InventoryLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryLogRepository extends JpaRepository<InventoryLog, Long> {

    Page<InventoryLog> findByProductId(Long productId, Pageable pageable);

    @Query("SELECT il FROM InventoryLog il WHERE " +
           "(:productId IS NULL OR il.product.id = :productId) AND " +
           "(:type IS NULL OR il.type = :type) AND " +
           "(:reference IS NULL OR il.reference LIKE %:reference%)")
    Page<InventoryLog> searchInventoryLogs(@Param("productId") Long productId,
                                           @Param("type") String type,
                                           @Param("reference") String reference,
                                           Pageable pageable);

    List<InventoryLog> findByProductIdOrderByCreatedAtDesc(Long productId);
}
