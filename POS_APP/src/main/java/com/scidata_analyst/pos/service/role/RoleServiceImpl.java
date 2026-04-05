package com.scidata_analyst.pos.service.role;

import com.scidata_analyst.pos.dto.role.RoleDTO;
import com.scidata_analyst.pos.dto.user.UserDTO;
import com.scidata_analyst.pos.entity.Role;
import com.scidata_analyst.pos.entity.User;
import com.scidata_analyst.pos.repository.role.RoleRepository;
import com.scidata_analyst.pos.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        if (roleRepository.existsByName(roleDTO.getName())) {
            throw new IllegalArgumentException("Role with name " + roleDTO.getName() + " already exists");
        }

        Role role = Role.builder()
                .name(roleDTO.getName())
                .description(roleDTO.getDescription())
                .build();

        Role saved = roleRepository.save(role);
        return mapToDTO(saved);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));

        if (roleDTO.getName() != null) {
            if (!role.getName().equals(roleDTO.getName()) && roleRepository.existsByName(roleDTO.getName())) {
                throw new IllegalArgumentException("Role with name " + roleDTO.getName() + " already exists");
            }
            role.setName(roleDTO.getName());
        }
        if (roleDTO.getDescription() != null) role.setDescription(roleDTO.getDescription());
        if (roleDTO.getIsActive() != null) role.setIsActive(roleDTO.getIsActive());

        Role updated = roleRepository.save(role);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        return mapToDTO(role);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDTO getRoleByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + name));
        return mapToDTO(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> getAllActiveRoles() {
        return roleRepository.findByIsActiveTrue()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new EntityNotFoundException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return roleRepository.existsByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getRoleUsers(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRoles() != null && u.getRoles().contains(role))
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Long getRoleUserCount(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleId));

        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRoles() != null && u.getRoles().contains(role))
                .count();
    }

    private RoleDTO mapToDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .isActive(role.getIsActive())
                .userCount(0L)
                .permissions(role.getIsActive() != null && role.getIsActive()
                        ? Set.of("READ", "WRITE")
                        : Set.of())
                .build();
    }

    private UserDTO mapUserToDTO(User user) {
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
                .lastLoginAt(user.getLastLoginAt())
                .build();
    }
}
