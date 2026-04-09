package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.Devices;
import com.example.pos.dtos.Hardware.DevicesDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Devices entity.
 * <p>
 * Responsible for converting between Devices entity and DevicesDto.
 */
@Component
public class DevicesMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Devices entity
     * @return DevicesDto representation
     */
    public DevicesDto toDto(Devices entity) {
        if (entity == null) return null;
        DevicesDto dto = new DevicesDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the DevicesDto
     * @return Devices entity
     */
    public Devices toEntity(DevicesDto dto) {
        if (dto == null) return null;
        Devices entity = new Devices();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Devices
     * @return list of DevicesDto
     */
    public List<DevicesDto> toDtoList(List<Devices> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
