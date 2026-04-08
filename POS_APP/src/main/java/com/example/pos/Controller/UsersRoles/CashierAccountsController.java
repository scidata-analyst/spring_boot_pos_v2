package com.example.pos.Controller.UsersRoles;

import com.example.pos.DTO.UsersRoles.CashierAccountsDTO;
import com.example.pos.Entity.UsersRoles.CashierAccounts;
import com.example.pos.Request.UsersRoles.CreateCashierAccountsRequest;
import com.example.pos.Request.UsersRoles.LoginRequest;
import com.example.pos.Request.UsersRoles.UpdateCashierAccountsRequest;
import com.example.pos.Response.UsersRoles.CashierAccountsResponse;
import com.example.pos.Response.UsersRoles.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cashier-accounts")
public class CashierAccountsController {

    @GetMapping
    public ResponseEntity<Page<CashierAccountsResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashierAccountsResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<CashierAccountsResponse> store(@Valid @RequestBody CreateCashierAccountsRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CashierAccountsResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateCashierAccountsRequest request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
