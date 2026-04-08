package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.Transactions;
import java.util.List;
import java.util.Optional;

public interface TransactionsService {
    List<Transactions> all();
    List<Transactions> index();
    Optional<Transactions> show(Long id);
    Transactions store(Transactions entity);
    Transactions update(Long id, Transactions entity);
    void destroy(Long id);
}
