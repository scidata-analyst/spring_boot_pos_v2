package com.scidata_analyst.pos.service.user;

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
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDTO createUser(CreateUserRequest request);

    UserDTO updateUser(Long id, UpdateUserRequest request);

    UserDTO getUserById(Long id);

    UserDTO getUserByUsername(String username);

    Page<UserDTO> searchUsers(SearchUserRequest request);

    List<UserDTO> getAllActiveUsers();

    LoginResponse login(LoginRequest request);

    void logout(Long userId);

    PasswordChangeResponse changePassword(Long userId, ChangePasswordRequest request);

    UserSessionDTO getCurrentSession(Long userId);

    UserActivityDTO getUserActivity(Long userId);

    void deleteUser(Long id);

    void deactivateUser(Long id);

    void lockUser(Long userId, String reason);

    void unlockUser(Long userId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<RoleDTO> getUserRoles(Long userId);

    UserDTO assignRole(Long userId, Long roleId);

    UserDTO removeRole(Long userId, Long roleId);

    UserDTO setUserRoles(Long userId, List<Long> roleIds);

    List<SaleSummaryDTO> getUserSales(Long userId);

    Map<String, Object> getUserSalesSummary(Long userId);

    List<UserDTO> getUsersByRole(Long roleId);
}
