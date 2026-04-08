package com.example.pos.Controller.PaymentAccounting;

import com.example.pos.Response.PaymentAccounting.ReconciliationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reconciliation")
public class ReconciliationController {

    @GetMapping
    public ResponseEntity<Page<ReconciliationResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReconciliationResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ReconciliationResponse> store(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReconciliationResponse> update(@PathVariable Long id, @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
