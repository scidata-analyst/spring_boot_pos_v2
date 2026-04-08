package com.example.pos.Service.UsersRoles;

import com.example.pos.Entity.UsersRoles.CashierAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashierAccountsServiceImpl implements CashierAccountsService {

    @Override
    public List<CashierAccounts> all() {
        return List.of();
    }

    @Override
    public List<CashierAccounts> index() {
        return List.of();
    }

    @Override
    public Optional<CashierAccounts> show(Long id) {
        return Optional.empty();
    }

    @Override
    public CashierAccounts store(CashierAccounts entity) {
        return entity;
    }

    @Override
    public CashierAccounts update(Long id, CashierAccounts entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
