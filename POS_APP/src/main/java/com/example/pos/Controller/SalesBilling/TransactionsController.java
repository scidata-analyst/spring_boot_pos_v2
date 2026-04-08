package com.example.pos.Controller.SalesBilling;

import com.example.pos.Response.SalesBilling.TransactionsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @GetMapping
    public ResponseEntity<Page<TransactionsResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionsResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<TransactionsResponse> store(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionsResponse> update(@PathVariable Long id, @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
