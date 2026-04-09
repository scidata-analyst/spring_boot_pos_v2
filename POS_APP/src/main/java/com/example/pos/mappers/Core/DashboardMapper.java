package com.example.pos.mappers.Core;

import com.example.pos.entities.Core.Dashboard;
import com.example.pos.dtos.Core.DashboardDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Dashboard entity.
 * <p>
 * Responsible for converting between Dashboard entity and DashboardDto.
 */
@Component
public class DashboardMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Dashboard entity
     * @return DashboardDto representation
     */
    public DashboardDto toDto(Dashboard entity) {
        if (entity == null) return null;
        DashboardDto dto = new DashboardDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the DashboardDto
     * @return Dashboard entity
     */
    public Dashboard toEntity(DashboardDto dto) {
        if (dto == null) return null;
        Dashboard entity = new Dashboard();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Dashboard
     * @return list of DashboardDto
     */
    public List<DashboardDto> toDtoList(List<Dashboard> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
