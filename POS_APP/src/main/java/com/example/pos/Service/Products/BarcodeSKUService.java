package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.BarcodeSKU;
import java.util.List;
import java.util.Optional;

public interface BarcodeSKUService {
    List<BarcodeSKU> all();
    List<BarcodeSKU> index();
    Optional<BarcodeSKU> show(Long id);
    BarcodeSKU store(BarcodeSKU entity);
    BarcodeSKU update(Long id, BarcodeSKU entity);
    void destroy(Long id);
}
