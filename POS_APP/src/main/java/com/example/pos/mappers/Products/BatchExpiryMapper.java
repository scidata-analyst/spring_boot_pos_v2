package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.BatchExpiry;
import com.example.pos.dtos.Products.BatchExpiryDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for BatchExpiry entity.
 * <p>
 * Responsible for converting between BatchExpiry entity and BatchExpiryDto.
 */
@Component
public class BatchExpiryMapper {

    /**
     * Convert entity to DTO.
     * @param entity the BatchExpiry entity
     * @return BatchExpiryDto representation
     */
    public BatchExpiryDto toDto(BatchExpiry entity) {
        if (entity == null) return null;
        BatchExpiryDto dto = new BatchExpiryDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the BatchExpiryDto
     * @return BatchExpiry entity
     */
    public BatchExpiry toEntity(BatchExpiryDto dto) {
        if (dto == null) return null;
        BatchExpiry entity = new BatchExpiry();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of BatchExpiry
     * @return list of BatchExpiryDto
     */
    public List<BatchExpiryDto> toDtoList(List<BatchExpiry> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
