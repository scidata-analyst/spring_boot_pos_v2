package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.SupplierDirectory;
import com.example.pos.dtos.request.Suppliers.SupplierDirectoryRequest;
import com.example.pos.dtos.response.Suppliers.SupplierDirectoryResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierDirectoryMapper {

    public SupplierDirectoryResponse toResponse(SupplierDirectory entity) {
        if (entity == null)
            return null;

        SupplierDirectoryResponse response = new SupplierDirectoryResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setContactPerson(entity.getContactPerson());
        response.setEmail(entity.getEmail());
        response.setPhone(entity.getPhone());
        response.setAddress(entity.getAddress());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public SupplierDirectory toEntity(SupplierDirectoryRequest request) {
        if (request == null)
            return null;

        SupplierDirectory entity = new SupplierDirectory();

        entity.setName(request.getName());
        entity.setContactPerson(request.getContactPerson());
        entity.setEmail(request.getEmail());
        entity.setPhone(request.getPhone());
        entity.setAddress(request.getAddress());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(SupplierDirectoryRequest request, SupplierDirectory entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setContactPerson(request.getContactPerson());
        entity.setEmail(request.getEmail());
        entity.setPhone(request.getPhone());
        entity.setAddress(request.getAddress());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<SupplierDirectoryResponse> toResponseList(List<SupplierDirectory> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
