package com.example.pos.Service.UsersRoles;

import com.example.pos.Entity.UsersRoles.CashierAccounts;
import java.util.List;
import java.util.Optional;

public interface CashierAccountsService {
    List<CashierAccounts> all();
    List<CashierAccounts> index();
    Optional<CashierAccounts> show(Long id);
    CashierAccounts store(CashierAccounts entity);
    CashierAccounts update(Long id, CashierAccounts entity);
    void destroy(Long id);
}
