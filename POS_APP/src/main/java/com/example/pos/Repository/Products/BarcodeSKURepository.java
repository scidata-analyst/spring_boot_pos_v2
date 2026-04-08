package com.example.pos.Repository.Products;

import com.example.pos.Entity.Products.BarcodeSKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeSKURepository extends JpaRepository<BarcodeSKU, Long> {
}
