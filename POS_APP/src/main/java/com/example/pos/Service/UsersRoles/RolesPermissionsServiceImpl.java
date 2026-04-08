package com.example.pos.Service.UsersRoles;

import com.example.pos.Entity.UsersRoles.RolesPermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesPermissionsServiceImpl implements RolesPermissionsService {

    @Override
    public List<RolesPermissions> all() {
        return List.of();
    }

    @Override
    public List<RolesPermissions> index() {
        return List.of();
    }

    @Override
    public Optional<RolesPermissions> show(Long id) {
        return Optional.empty();
    }

    @Override
    public RolesPermissions store(RolesPermissions entity) {
        return entity;
    }

    @Override
    public RolesPermissions update(Long id, RolesPermissions entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
