package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.SupplierPayments;
import java.util.List;
import java.util.Optional;

public interface SupplierPaymentsService {
    List<SupplierPayments> all();
    List<SupplierPayments> index();
    Optional<SupplierPayments> show(Long id);
    SupplierPayments store(SupplierPayments entity);
    SupplierPayments update(Long id, SupplierPayments entity);
    void destroy(Long id);
}
