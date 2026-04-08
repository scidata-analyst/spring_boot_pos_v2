package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.Invoices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoicesServiceImpl implements InvoicesService {

    @Override
    public List<Invoices> all() {
        return List.of();
    }

    @Override
    public List<Invoices> index() {
        return List.of();
    }

    @Override
    public Optional<Invoices> show(Long id) {
        return Optional.empty();
    }

    @Override
    public Invoices store(Invoices entity) {
        return entity;
    }

    @Override
    public Invoices update(Long id, Invoices entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
