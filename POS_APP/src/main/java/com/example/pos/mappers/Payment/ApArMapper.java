package com.example.pos.mappers.Payment;

import com.example.pos.entities.Payment.ApAr;
import com.example.pos.dtos.Payment.ApArDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for ApAr entity.
 * <p>
 * Responsible for converting between ApAr entity and ApArDto.
 */
@Component
public class ApArMapper {

    /**
     * Convert entity to DTO.
     * @param entity the ApAr entity
     * @return ApArDto representation
     */
    public ApArDto toDto(ApAr entity) {
        if (entity == null) return null;
        ApArDto dto = new ApArDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the ApArDto
     * @return ApAr entity
     */
    public ApAr toEntity(ApArDto dto) {
        if (dto == null) return null;
        ApAr entity = new ApAr();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of ApAr
     * @return list of ApArDto
     */
    public List<ApArDto> toDtoList(List<ApAr> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
