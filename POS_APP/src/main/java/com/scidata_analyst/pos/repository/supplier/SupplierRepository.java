package com.scidata_analyst.pos.repository.supplier;

import com.scidata_analyst.pos.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByName(String name);

    Optional<Supplier> findByEmail(String email);

    boolean existsByEmail(String email);

    Page<Supplier> findByIsActiveTrue(Pageable pageable);

    @Query("SELECT s FROM Supplier s WHERE " +
           "(:keyword IS NULL OR s.name LIKE %:keyword% OR s.contactPerson LIKE %:keyword% OR s.email LIKE %:keyword% OR s.phone LIKE %:keyword%) AND " +
           "(:email IS NULL OR s.email = :email) AND " +
           "(:phone IS NULL OR s.phone = :phone) AND " +
           "(:isActive IS NULL OR s.isActive = :isActive)")
    Page<Supplier> searchSuppliers(@Param("keyword") String keyword,
                                   @Param("email") String email,
                                   @Param("phone") String phone,
                                   @Param("isActive") Boolean isActive,
                                   Pageable pageable);
}
