package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.CashRegister;
import java.util.List;
import java.util.Optional;

public interface CashRegisterService {
    List<CashRegister> all();
    List<CashRegister> index();
    Optional<CashRegister> show(Long id);
    CashRegister store(CashRegister entity);
    CashRegister update(Long id, CashRegister entity);
    void destroy(Long id);
}
