package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierPayments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierPaymentsServiceImpl implements SupplierPaymentsService {

    @Override
    public List<SupplierPayments> all() {
        return List.of();
    }

    @Override
    public List<SupplierPayments> index() {
        return List.of();
    }

    @Override
    public Optional<SupplierPayments> show(Long id) {
        return Optional.empty();
    }

    @Override
    public SupplierPayments store(SupplierPayments entity) {
        return entity;
    }

    @Override
    public SupplierPayments update(Long id, SupplierPayments entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
