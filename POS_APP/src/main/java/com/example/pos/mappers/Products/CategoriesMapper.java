package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.Categories;
import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriesMapper {

    public CategoriesResponse toResponse(Categories entity) {
        if (entity == null)
            return null;

        CategoriesResponse response = new CategoriesResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setIcon(entity.getIcon());
        response.setStatus(entity.getStatus());
        response.setDescription(entity.getDescription());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    public Categories toEntity(CategoriesRequest request) {
        if (request == null)
            return null;

        Categories entity = new Categories();

        entity.setName(request.getName());
        entity.setIcon(request.getIcon());
        entity.setStatus(request.getStatus());
        entity.setDescription(request.getDescription());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());

        return entity;
    }

    public void updateEntity(CategoriesRequest request, Categories entity) {
        if (request == null || entity == null)
            return;

        entity.setName(request.getName());
        entity.setIcon(request.getIcon());
        entity.setStatus(request.getStatus());
        entity.setDescription(request.getDescription());
        entity.setCreatedAt(request.getCreatedAt());
        entity.setUpdatedAt(request.getUpdatedAt());
    }

    public List<CategoriesResponse> toResponseList(List<Categories> entities) {
        if (entities == null)
            return List.of();

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
