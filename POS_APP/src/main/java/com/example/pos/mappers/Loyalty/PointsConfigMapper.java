package com.example.pos.mappers.Loyalty;

import com.example.pos.entities.Loyalty.PointsConfig;
import com.example.pos.dtos.Loyalty.PointsConfigDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for PointsConfig entity.
 * <p>
 * Responsible for converting between PointsConfig entity and PointsConfigDto.
 */
@Component
public class PointsConfigMapper {

    /**
     * Convert entity to DTO.
     * @param entity the PointsConfig entity
     * @return PointsConfigDto representation
     */
    public PointsConfigDto toDto(PointsConfig entity) {
        if (entity == null) return null;
        PointsConfigDto dto = new PointsConfigDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the PointsConfigDto
     * @return PointsConfig entity
     */
    public PointsConfig toEntity(PointsConfigDto dto) {
        if (dto == null) return null;
        PointsConfig entity = new PointsConfig();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of PointsConfig
     * @return list of PointsConfigDto
     */
    public List<PointsConfigDto> toDtoList(List<PointsConfig> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
