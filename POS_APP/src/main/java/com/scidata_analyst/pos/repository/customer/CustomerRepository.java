package com.scidata_analyst.pos.repository.customer;

import com.scidata_analyst.pos.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByPhone(String phone);

    boolean existsByEmail(String email);

    Page<Customer> findByIsActiveTrue(Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE " +
           "(:keyword IS NULL OR c.firstName LIKE %:keyword% OR c.lastName LIKE %:keyword% OR c.email LIKE %:keyword% OR c.phone LIKE %:keyword%) AND " +
           "(:email IS NULL OR c.email = :email) AND " +
           "(:phone IS NULL OR c.phone = :phone) AND " +
           "(:isActive IS NULL OR c.isActive = :isActive)")
    Page<Customer> searchCustomers(@Param("keyword") String keyword,
                                   @Param("email") String email,
                                   @Param("phone") String phone,
                                   @Param("isActive") Boolean isActive,
                                   Pageable pageable);
}
