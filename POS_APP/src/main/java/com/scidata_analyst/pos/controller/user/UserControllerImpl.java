package com.scidata_analyst.pos.controller.user;

import com.scidata_analyst.pos.dto.user.UserDTO;
import com.scidata_analyst.pos.dto.user.UserSessionDTO;
import com.scidata_analyst.pos.dto.user.UserActivityDTO;
import com.scidata_analyst.pos.request.user.ChangePasswordRequest;
import com.scidata_analyst.pos.request.user.CreateUserRequest;
import com.scidata_analyst.pos.request.user.LoginRequest;
import com.scidata_analyst.pos.request.user.SearchUserRequest;
import com.scidata_analyst.pos.request.user.UpdateUserRequest;
import com.scidata_analyst.pos.response.user.LoginResponse;
import com.scidata_analyst.pos.response.user.PasswordChangeResponse;
import com.scidata_analyst.pos.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDTO created = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        UserDTO updated = userService.updateUser(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<UserDTO>> searchUsers(SearchUserRequest request) {
        Page<UserDTO> users = userService.searchUsers(request);
        return ResponseEntity.ok(users);
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
        List<UserDTO> users = userService.getAllActiveUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping("/{userId}/logout")
    public ResponseEntity<Void> logout(@PathVariable Long userId) {
        userService.logout(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{userId}/change-password")
    public ResponseEntity<PasswordChangeResponse> changePassword(@PathVariable Long userId, @Valid @RequestBody ChangePasswordRequest request) {
        PasswordChangeResponse response = userService.changePassword(userId, request);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{userId}/session")
    public ResponseEntity<UserSessionDTO> getCurrentSession(@PathVariable Long userId) {
        UserSessionDTO session = userService.getCurrentSession(userId);
        return ResponseEntity.ok(session);
    }

    @Override
    @GetMapping("/{userId}/activity")
    public ResponseEntity<UserActivityDTO> getUserActivity(@PathVariable Long userId) {
        UserActivityDTO activity = userService.getUserActivity(userId);
        return ResponseEntity.ok(activity);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{userId}/lock")
    public ResponseEntity<Void> lockUser(@PathVariable Long userId, @RequestParam String reason) {
        userService.lockUser(userId, reason);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{userId}/unlock")
    public ResponseEntity<Void> unlockUser(@PathVariable Long userId) {
        userService.unlockUser(userId);
        return ResponseEntity.noContent().build();
    }
}
