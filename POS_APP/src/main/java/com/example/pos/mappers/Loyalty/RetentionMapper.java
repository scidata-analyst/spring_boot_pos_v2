package com.example.pos.mappers.Loyalty;

import com.example.pos.entities.Loyalty.Retention;
import com.example.pos.dtos.Loyalty.RetentionDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Retention entity.
 * <p>
 * Responsible for converting between Retention entity and RetentionDto.
 */
@Component
public class RetentionMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Retention entity
     * @return RetentionDto representation
     */
    public RetentionDto toDto(Retention entity) {
        if (entity == null) return null;
        RetentionDto dto = new RetentionDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the RetentionDto
     * @return Retention entity
     */
    public Retention toEntity(RetentionDto dto) {
        if (dto == null) return null;
        Retention entity = new Retention();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Retention
     * @return list of RetentionDto
     */
    public List<RetentionDto> toDtoList(List<Retention> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
