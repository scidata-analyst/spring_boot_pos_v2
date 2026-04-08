package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.Invoices;
import java.util.List;
import java.util.Optional;

public interface InvoicesService {
    List<Invoices> all();
    List<Invoices> index();
    Optional<Invoices> show(Long id);
    Invoices store(Invoices entity);
    Invoices update(Long id, Invoices entity);
    void destroy(Long id);
}
