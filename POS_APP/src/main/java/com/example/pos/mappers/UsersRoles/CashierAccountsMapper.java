package com.example.pos.mappers.UsersRoles;

import com.example.pos.entities.UsersRoles.CashierAccounts;
import com.example.pos.dtos.request.UsersRoles.CashierAccountsRequest;
import com.example.pos.dtos.response.UsersRoles.CashierAccountsResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CashierAccountsMapper {

    public CashierAccountsResponse toResponse(CashierAccounts entity) {
        if (entity == null)
            return null;

        CashierAccountsResponse response = new CashierAccountsResponse();

        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setPassword(entity.getPassword());
        response.setEmployeeName(entity.getEmployeeName());
        response.setEmail(entity.getEmail());
        response.setPhoneNumber(entity.getPhoneNumber());
        response.setRoleId(entity.getRoleId());
        response.setStatus(entity.getStatus());
        response.setLastLogin(entity.getLastLogin());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public CashierAccounts toEntity(CashierAccountsRequest request) {
        if (request == null)
            return null;

        CashierAccounts entity = new CashierAccounts();

        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setEmployeeName(request.getEmployeeName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setRoleId(request.getRoleId());
        entity.setStatus(request.getStatus());
        entity.setLastLogin(request.getLastLogin());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CashierAccountsRequest request, CashierAccounts entity) {
        if (request == null || entity == null)
            return;

        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setEmployeeName(request.getEmployeeName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setRoleId(request.getRoleId());
        entity.setStatus(request.getStatus());
        entity.setLastLogin(request.getLastLogin());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CashierAccountsResponse> toResponseList(List<CashierAccounts> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
