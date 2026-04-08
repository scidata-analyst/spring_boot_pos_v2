package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.Transactions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {

    @Override
    public List<Transactions> all() {
        return List.of();
    }

    @Override
    public List<Transactions> index() {
        return List.of();
    }

    @Override
    public Optional<Transactions> show(Long id) {
        return Optional.empty();
    }

    @Override
    public Transactions store(Transactions entity) {
        return entity;
    }

    @Override
    public Transactions update(Long id, Transactions entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
