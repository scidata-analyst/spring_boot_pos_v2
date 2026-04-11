package com.example.pos.mappers.CustomersCRM;

import com.example.pos.entities.CustomersCRM.CustomerDirectory;
import com.example.pos.dtos.request.CustomersCRM.CustomerDirectoryRequest;
import com.example.pos.dtos.response.CustomersCRM.CustomerDirectoryResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDirectoryMapper {

    public CustomerDirectoryResponse toResponse(CustomerDirectory entity) {
        if (entity == null)
            return null;

        CustomerDirectoryResponse response = new CustomerDirectoryResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setPhoneNumber(entity.getPhoneNumber());
        response.setLoyaltyTier(entity.getLoyaltyTier());
        response.setPoints(entity.getPoints());
        response.setTotalSpent(entity.getTotalSpent());
        response.setVisits(entity.getVisits());
        response.setLastVisitDate(entity.getLastVisitDate());
        response.setStatus(entity.getStatus());
        response.setDateOfBirth(entity.getDateOfBirth());
        response.setNotes(entity.getNotes());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public CustomerDirectory toEntity(CustomerDirectoryRequest request) {
        if (request == null)
            return null;

        CustomerDirectory entity = new CustomerDirectory();

        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setLoyaltyTier(request.getLoyaltyTier());
        entity.setPoints(request.getPoints());
        entity.setTotalSpent(request.getTotalSpent());
        entity.setVisits(request.getVisits());
        entity.setLastVisitDate(request.getLastVisitDate());
        entity.setStatus(request.getStatus());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNotes(request.getNotes());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CustomerDirectoryRequest request, CustomerDirectory entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setLoyaltyTier(request.getLoyaltyTier());
        entity.setPoints(request.getPoints());
        entity.setTotalSpent(request.getTotalSpent());
        entity.setVisits(request.getVisits());
        entity.setLastVisitDate(request.getLastVisitDate());
        entity.setStatus(request.getStatus());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNotes(request.getNotes());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CustomerDirectoryResponse> toResponseList(List<CustomerDirectory> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
