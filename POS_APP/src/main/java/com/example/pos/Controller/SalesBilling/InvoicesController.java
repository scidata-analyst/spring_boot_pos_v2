package com.example.pos.Controller.SalesBilling;

import com.example.pos.Response.SalesBilling.InvoicesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    @GetMapping
    public ResponseEntity<Page<InvoicesResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoicesResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<InvoicesResponse> store(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoicesResponse> update(@PathVariable Long id, @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
