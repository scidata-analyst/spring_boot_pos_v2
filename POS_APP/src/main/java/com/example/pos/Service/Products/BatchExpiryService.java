package com.example.pos.Service.Products;

import com.example.pos.Entity.Products.BatchExpiry;
import java.util.List;
import java.util.Optional;

public interface BatchExpiryService {
    List<BatchExpiry> all();
    List<BatchExpiry> index();
    Optional<BatchExpiry> show(Long id);
    BatchExpiry store(BatchExpiry entity);
    BatchExpiry update(Long id, BatchExpiry entity);
    void destroy(Long id);
}
