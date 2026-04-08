package com.example.pos.Repository.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDirectoryRepository extends JpaRepository<SupplierDirectory, Long> {
}
