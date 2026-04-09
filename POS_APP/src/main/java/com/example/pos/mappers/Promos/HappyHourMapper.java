package com.example.pos.mappers.Promos;

import com.example.pos.entities.Promos.HappyHour;
import com.example.pos.dtos.Promos.HappyHourDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for HappyHour entity.
 * <p>
 * Responsible for converting between HappyHour entity and HappyHourDto.
 */
@Component
public class HappyHourMapper {

    /**
     * Convert entity to DTO.
     * @param entity the HappyHour entity
     * @return HappyHourDto representation
     */
    public HappyHourDto toDto(HappyHour entity) {
        if (entity == null) return null;
        HappyHourDto dto = new HappyHourDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the HappyHourDto
     * @return HappyHour entity
     */
    public HappyHour toEntity(HappyHourDto dto) {
        if (dto == null) return null;
        HappyHour entity = new HappyHour();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of HappyHour
     * @return list of HappyHourDto
     */
    public List<HappyHourDto> toDtoList(List<HappyHour> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
