package com.scidata_analyst.pos.service.user;

import com.scidata_analyst.pos.dto.role.RoleDTO;
import com.scidata_analyst.pos.dto.user.UserDTO;
import com.scidata_analyst.pos.dto.user.UserSessionDTO;
import com.scidata_analyst.pos.dto.user.UserActivityDTO;
import com.scidata_analyst.pos.dto.sale.SaleSummaryDTO;
import com.scidata_analyst.pos.entity.Role;
import com.scidata_analyst.pos.entity.Sale;
import com.scidata_analyst.pos.entity.User;
import com.scidata_analyst.pos.repository.role.RoleRepository;
import com.scidata_analyst.pos.repository.sale.SaleRepository;
import com.scidata_analyst.pos.repository.user.UserRepository;
import com.scidata_analyst.pos.request.user.ChangePasswordRequest;
import com.scidata_analyst.pos.request.user.CreateUserRequest;
import com.scidata_analyst.pos.request.user.LoginRequest;
import com.scidata_analyst.pos.request.user.SearchUserRequest;
import com.scidata_analyst.pos.request.user.UpdateUserRequest;
import com.scidata_analyst.pos.response.user.LoginResponse;
import com.scidata_analyst.pos.response.user.PasswordChangeResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SaleRepository saleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("User with username " + request.getUsername() + " already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .build();

        if (request.getRoleId() != null) {
            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + request.getRoleId()));
            user.setRoles(new HashSet<>(Set.of(role)));
        }

        User saved = userRepository.save(user);
        return mapToDTO(saved);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        if (request.getFirstName() != null) user.setFirstName(request.getFirstName());
        if (request.getLastName() != null) user.setLastName(request.getLastName());
        if (request.getEmail() != null) {
            if (!user.getEmail().equals(request.getEmail()) && userRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists");
            }
            user.setEmail(request.getEmail());
        }
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getIsActive() != null) user.setIsActive(request.getIsActive());

        User updated = userRepository.save(user);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return mapToDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));
        return mapToDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> searchUsers(SearchUserRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<User> users = userRepository.searchUsers(
                request.getKeyword(),
                request.getEmail(),
                request.getIsActive(),
                pageable
        );

        return users.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllActiveUsers() {
        return userRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        if (!user.getIsActive()) {
            throw new IllegalStateException("User account is deactivated");
        }

        if (user.getIsAccountLocked()) {
            throw new IllegalStateException("User account is locked");
        }

        user.setLastLoginAt(LocalDateTime.now());
        user.setFailedLoginAttempts(0);
        userRepository.save(user);

        String roleName = user.getRoles() != null && !user.getRoles().isEmpty()
                ? user.getRoles().iterator().next().getName()
                : "USER";

        return LoginResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .token("jwt-token-placeholder")
                .refreshToken("refresh-token-placeholder")
                .role(roleName)
                .expiresIn(3600L)
                .build();
    }

    @Override
    public void logout(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        user.setLastLoginAt(null);
        userRepository.save(user);
    }

    @Override
    public PasswordChangeResponse changePassword(Long userId, ChangePasswordRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }

        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("New password and confirm password do not match");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        return PasswordChangeResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .success(true)
                .message("Password changed successfully")
                .updatedAt(LocalDateTime.now().toString())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserSessionDTO getCurrentSession(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return UserSessionDTO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .role(user.getRoles() != null && !user.getRoles().isEmpty()
                        ? user.getRoles().iterator().next().getName() : "USER")
                .token("session-token-placeholder")
                .refreshToken("refresh-token-placeholder")
                .expiresIn(3600L)
                .loginTime(user.getLastLoginAt() != null ? user.getLastLoginAt().toString() : null)
                .ipAddress("127.0.0.1")
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserActivityDTO getUserActivity(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return UserActivityDTO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .lastLoginAt(user.getLastLoginAt())
                .lastActivityAt(user.getUpdatedAt())
                .lastAction("Last update")
                .sessionCount(0)
                .isActive(user.getIsActive())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void deactivateUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        user.setIsActive(false);
        userRepository.save(user);
    }

    @Override
    public void lockUser(Long userId, String reason) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        user.setIsAccountLocked(true);
        userRepository.save(user);
    }

    @Override
    public void unlockUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        user.setIsAccountLocked(false);
        user.setFailedLoginAttempts(0);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> getUserRoles(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return user.getRoles() != null
                ? user.getRoles().stream().map(this::mapRoleToDTO).collect(Collectors.toList())
                : List.of();
    }

    @Override
    public UserDTO assignRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        if (user.getRoles() == null) user.setRoles(new HashSet<>());
        user.getRoles().add(role);
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO removeRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        if (user.getRoles() != null) {
            user.getRoles().removeIf(r -> r.getId().equals(roleId));
        }
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO setUserRoles(Long userId, List<Long> roleIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        Set<Role> roles = new HashSet<>();
        for (Long roleId : roleIds) {
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));
            roles.add(role);
        }
        user.setRoles(roles);
        return mapToDTO(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleSummaryDTO> getUserSales(Long userId) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "createdAt"));
        return saleRepository.searchSales(null, null, userId, null, null, null, null, pageable)
                .getContent()
                .stream()
                .map(this::mapToSaleSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getUserSalesSummary(Long userId) {
        List<Sale> sales = saleRepository.searchSales(null, null, userId, null, null, null, null,
                PageRequest.of(0, Integer.MAX_VALUE)).getContent();

        long totalSales = sales.size();
        BigDecimal totalRevenue = sales.stream().map(Sale::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal averageSale = totalSales > 0
                ? totalRevenue.divide(BigDecimal.valueOf(totalSales), 2, BigDecimal.ROUND_HALF_UP)
                : BigDecimal.ZERO;

        Map<String, Object> summary = new HashMap<>();
        summary.put("userId", userId);
        summary.put("totalSales", totalSales);
        summary.put("totalRevenue", totalRevenue);
        summary.put("averageSale", averageSale);
        return summary;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getUsersByRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRoles() != null && u.getRoles().contains(role))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapToDTO(User user) {
        UserDTO.RoleDTO roleDTO = null;
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            Role role = user.getRoles().iterator().next();
            roleDTO = UserDTO.RoleDTO.builder()
                    .id(role.getId())
                    .name(role.getName())
                    .description(role.getDescription())
                    .build();
        }

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .phone(user.getPhone())
                .isActive(user.getIsActive())
                .isAccountLocked(user.getIsAccountLocked())
                .failedLoginAttempts(user.getFailedLoginAttempts())
                .lastLoginAt(user.getLastLoginAt())
                .role(roleDTO)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    private RoleDTO mapRoleToDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .isActive(role.getIsActive())
                .build();
    }

    private SaleSummaryDTO mapToSaleSummaryDTO(Sale sale) {
        return SaleSummaryDTO.builder()
                .id(sale.getId())
                .invoiceNumber(sale.getInvoiceNumber())
                .customerName(sale.getCustomer() != null ? sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName() : "Walk-in")
                .cashierName(sale.getUser() != null ? sale.getUser().getUsername() : null)
                .itemCount(sale.getSaleItems() != null ? sale.getSaleItems().size() : 0)
                .subtotal(sale.getSubtotal())
                .tax(sale.getTax())
                .discount(sale.getDiscount())
                .total(sale.getTotal())
                .paymentMethod(sale.getPaymentMethod())
                .status(sale.getStatus())
                .createdAt(sale.getCreatedAt())
                .build();
    }
}
