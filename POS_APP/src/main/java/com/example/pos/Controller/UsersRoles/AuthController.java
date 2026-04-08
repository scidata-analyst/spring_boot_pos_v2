package com.example.pos.Controller.UsersRoles;

import com.example.pos.Request.UsersRoles.LoginRequest;
import com.example.pos.Response.UsersRoles.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok().build();
    }
}
