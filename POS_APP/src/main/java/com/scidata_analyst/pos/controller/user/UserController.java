package com.scidata_analyst.pos.controller.user;

import com.scidata_analyst.pos.dto.role.RoleDTO;
import com.scidata_analyst.pos.dto.user.UserDTO;
import com.scidata_analyst.pos.dto.user.UserSessionDTO;
import com.scidata_analyst.pos.dto.user.UserActivityDTO;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
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
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDTO created = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        UserDTO updated = userService.updateUser(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> searchUsers(SearchUserRequest request) {
        Page<UserDTO> users = userService.searchUsers(request);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/active")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
        List<UserDTO> users = userService.getAllActiveUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/logout")
    public ResponseEntity<Void> logout(@PathVariable Long userId) {
        userService.logout(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/change-password")
    public ResponseEntity<PasswordChangeResponse> changePassword(@PathVariable Long userId, @Valid @RequestBody ChangePasswordRequest request) {
        PasswordChangeResponse response = userService.changePassword(userId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/session")
    public ResponseEntity<UserSessionDTO> getCurrentSession(@PathVariable Long userId) {
        UserSessionDTO session = userService.getCurrentSession(userId);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/{userId}/activity")
    public ResponseEntity<UserActivityDTO> getUserActivity(@PathVariable Long userId) {
        UserActivityDTO activity = userService.getUserActivity(userId);
        return ResponseEntity.ok(activity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/lock")
    public ResponseEntity<Void> lockUser(@PathVariable Long userId, @RequestParam String reason) {
        userService.lockUser(userId, reason);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/unlock")
    public ResponseEntity<Void> unlockUser(@PathVariable Long userId) {
        userService.unlockUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/roles")
    public ResponseEntity<List<RoleDTO>> getUserRoles(@PathVariable Long id) {
        List<RoleDTO> roles = userService.getUserRoles(id);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/{id}/roles/{roleId}")
    public ResponseEntity<UserDTO> assignRoleToUser(@PathVariable Long id, @PathVariable Long roleId) {
        UserDTO updated = userService.assignRole(id, roleId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}/roles/{roleId}")
    public ResponseEntity<UserDTO> removeRoleFromUser(@PathVariable Long id, @PathVariable Long roleId) {
        UserDTO updated = userService.removeRole(id, roleId);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/roles")
    public ResponseEntity<UserDTO> setUserRoles(@PathVariable Long id, @RequestBody List<Long> roleIds) {
        UserDTO updated = userService.setUserRoles(id, roleIds);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}/sales")
    public ResponseEntity<List<SaleSummaryDTO>> getUserSales(@PathVariable Long id) {
        List<SaleSummaryDTO> sales = userService.getUserSales(id);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}/sales/summary")
    public ResponseEntity<Map<String, Object>> getUserSalesSummary(@PathVariable Long id) {
        Map<String, Object> summary = userService.getUserSalesSummary(id);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable Long roleId) {
        List<UserDTO> users = userService.getUsersByRole(roleId);
        return ResponseEntity.ok(users);
    }
}
