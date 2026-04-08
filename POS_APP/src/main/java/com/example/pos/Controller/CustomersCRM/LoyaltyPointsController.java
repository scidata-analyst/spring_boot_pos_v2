package com.example.pos.Controller.CustomersCRM;

import com.example.pos.Response.CustomersCRM.LoyaltyPointsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loyalty-points")
public class LoyaltyPointsController {

    @GetMapping
    public ResponseEntity<Page<LoyaltyPointsResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyPointsResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<LoyaltyPointsResponse> store(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoyaltyPointsResponse> update(@PathVariable Long id, @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
