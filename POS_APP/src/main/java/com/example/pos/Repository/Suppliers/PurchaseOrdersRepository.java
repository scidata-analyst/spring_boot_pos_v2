package com.example.pos.Repository.Suppliers;

import com.example.pos.Entity.Suppliers.PurchaseOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrders, Long> {
}
