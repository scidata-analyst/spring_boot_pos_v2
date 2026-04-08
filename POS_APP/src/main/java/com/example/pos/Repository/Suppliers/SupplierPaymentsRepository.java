package com.example.pos.Repository.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierPaymentsRepository extends JpaRepository<SupplierPayments, Long> {
}
