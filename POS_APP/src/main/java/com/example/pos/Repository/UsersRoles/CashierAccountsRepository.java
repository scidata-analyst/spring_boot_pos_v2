package com.example.pos.Repository.UsersRoles;

import com.example.pos.Entity.UsersRoles.CashierAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierAccountsRepository extends JpaRepository<CashierAccounts, Long> {
}
