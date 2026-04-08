package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierDirectory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierDirectoryServiceImpl implements SupplierDirectoryService {

    @Override
    public List<SupplierDirectory> all() {
        return List.of();
    }

    @Override
    public List<SupplierDirectory> index() {
        return List.of();
    }

    @Override
    public Optional<SupplierDirectory> show(Long id) {
        return Optional.empty();
    }

    @Override
    public SupplierDirectory store(SupplierDirectory entity) {
        return entity;
    }

    @Override
    public SupplierDirectory update(Long id, SupplierDirectory entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
