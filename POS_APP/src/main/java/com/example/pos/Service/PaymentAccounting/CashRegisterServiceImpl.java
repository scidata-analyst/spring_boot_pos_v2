package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.CashRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashRegisterServiceImpl implements CashRegisterService {

    @Override
    public List<CashRegister> all() {
        return List.of();
    }

    @Override
    public List<CashRegister> index() {
        return List.of();
    }

    @Override
    public Optional<CashRegister> show(Long id) {
        return Optional.empty();
    }

    @Override
    public CashRegister store(CashRegister entity) {
        return entity;
    }

    @Override
    public CashRegister update(Long id, CashRegister entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
