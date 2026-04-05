package com.scidata_analyst.pos.repository.sale;

import com.scidata_analyst.pos.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findByInvoiceNumber(String invoiceNumber);

    boolean existsByInvoiceNumber(String invoiceNumber);

    @Query("SELECT s FROM Sale s WHERE " +
           "(:invoiceNumber IS NULL OR s.invoiceNumber LIKE %:invoiceNumber%) AND " +
           "(:customerId IS NULL OR s.customer.id = :customerId) AND " +
           "(:userId IS NULL OR s.user.id = :userId) AND " +
           "(:paymentMethod IS NULL OR s.paymentMethod = :paymentMethod) AND " +
           "(:status IS NULL OR s.status = :status) AND " +
           "(:startDate IS NULL OR s.createdAt >= :startDate) AND " +
           "(:endDate IS NULL OR s.createdAt <= :endDate)")
    Page<Sale> searchSales(@Param("invoiceNumber") String invoiceNumber,
                           @Param("customerId") Long customerId,
                           @Param("userId") Long userId,
                           @Param("paymentMethod") String paymentMethod,
                           @Param("status") String status,
                           @Param("startDate") LocalDateTime startDate,
                           @Param("endDate") LocalDateTime endDate,
                           Pageable pageable);

    @Query("SELECT COALESCE(SUM(s.total), 0) FROM Sale s WHERE s.createdAt BETWEEN :startDate AND :endDate")
    BigDecimal getTotalSalesByDateRange(@Param("startDate") LocalDateTime startDate,
                                        @Param("endDate") LocalDateTime endDate);

    @Query("SELECT COUNT(s) FROM Sale s WHERE s.createdAt BETWEEN :startDate AND :endDate")
    Long getTotalTransactionsByDateRange(@Param("startDate") LocalDateTime startDate,
                                         @Param("endDate") LocalDateTime endDate);
}
