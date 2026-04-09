package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.RestockAlerts;
import com.example.pos.dtos.Suppliers.RestockAlertsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for RestockAlerts entity.
 * <p>
 * Responsible for converting between RestockAlerts entity and RestockAlertsDto.
 */
@Component
public class RestockAlertsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the RestockAlerts entity
     * @return RestockAlertsDto representation
     */
    public RestockAlertsDto toDto(RestockAlerts entity) {
        if (entity == null) return null;
        RestockAlertsDto dto = new RestockAlertsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the RestockAlertsDto
     * @return RestockAlerts entity
     */
    public RestockAlerts toEntity(RestockAlertsDto dto) {
        if (dto == null) return null;
        RestockAlerts entity = new RestockAlerts();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of RestockAlerts
     * @return list of RestockAlertsDto
     */
    public List<RestockAlertsDto> toDtoList(List<RestockAlerts> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
