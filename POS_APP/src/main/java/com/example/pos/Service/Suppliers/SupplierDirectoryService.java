package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierDirectory;
import java.util.List;
import java.util.Optional;

public interface SupplierDirectoryService {
    List<SupplierDirectory> all();
    List<SupplierDirectory> index();
    Optional<SupplierDirectory> show(Long id);
    SupplierDirectory store(SupplierDirectory entity);
    SupplierDirectory update(Long id, SupplierDirectory entity);
    void destroy(Long id);
}
