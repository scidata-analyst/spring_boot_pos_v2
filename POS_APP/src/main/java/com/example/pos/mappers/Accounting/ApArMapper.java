package com.example.pos.mappers.Accounting;

import com.example.pos.entities.Accounting.ApAr;
import com.example.pos.dtos.request.Accounting.ApArRequest;
import com.example.pos.dtos.response.Accounting.ApArResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for ApAr entity.
 *
 * <p>
 * This component is responsible for converting between:
 * <ul>
 * <li>{@link ApAr} entity</li>
 * <li>{@link ApArRequest} request DTO</li>
 * <li>{@link ApArResponse} response DTO</li>
 * </ul>
 *
 * <p>
 * It ensures separation of concerns between API layer and persistence layer
 * following Spring Boot MVC architecture principles.
 *
 * @author POS Application
 * @version 1.0
 * @since 2024
 */
@Component
public class ApArMapper {

    /**
     * Converts {@link ApAr} entity to {@link ApArResponse}.
     *
     * @param entity the ApAr entity
     * @return mapped ApArResponse or null if entity is null
     */
    public ApArResponse toResponse(ApAr entity) {
        if (entity == null) {
            return null;
        }

        ApArResponse response = new ApArResponse();

        response.setId(entity.getId());
        response.setType(entity.getType());
        response.setReferenceId(entity.getReferenceId());
        response.setCustomerId(entity.getCustomerId());
        response.setSupplierId(entity.getSupplierId());
        response.setAmount(entity.getAmount());
        response.setDueDate(entity.getDueDate());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());

        return response;
    }

    /**
     * Converts {@link ApArRequest} to {@link ApAr} entity.
     *
     * @param request the request DTO
     * @return mapped ApAr entity or null if request is null
     */
    public ApAr toEntity(ApArRequest request) {
        if (request == null) {
            return null;
        }

        ApAr entity = new ApAr();

        entity.setId(request.getId());
        entity.setType(request.getType());
        entity.setReferenceId(request.getReferenceId());
        entity.setCustomerId(request.getCustomerId());
        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setDueDate(request.getDueDate());
        entity.setStatus(request.getStatus());

        return entity;
    }

    /**
     * Updates an existing {@link ApAr} entity using {@link ApArRequest}.
     *
     * @param request the request DTO containing updated data
     * @param entity  the existing entity to update
     */
    public void updateEntityFromRequest(ApArRequest request, ApAr entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setType(request.getType());
        entity.setReferenceId(request.getReferenceId());
        entity.setCustomerId(request.getCustomerId());
        entity.setSupplierId(request.getSupplierId());
        entity.setAmount(request.getAmount());
        entity.setDueDate(request.getDueDate());
        entity.setStatus(request.getStatus());
    }

    /**
     * Converts a list of {@link ApAr} entities to {@link ApArResponse} list.
     *
     * @param entities list of ApAr entities
     * @return list of mapped responses or empty list if null
     */
    public List<ApArResponse> toResponseList(List<ApAr> entities) {
        if (entities == null) {
            return List.of();
        }

        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}