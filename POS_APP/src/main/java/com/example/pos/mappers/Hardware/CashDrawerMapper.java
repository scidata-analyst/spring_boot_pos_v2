package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.CashDrawer;
import com.example.pos.dtos.Hardware.CashDrawerDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for CashDrawer entity.
 * <p>
 * Responsible for converting between CashDrawer entity and CashDrawerDto.
 */
@Component
public class CashDrawerMapper {

    /**
     * Convert entity to DTO.
     * @param entity the CashDrawer entity
     * @return CashDrawerDto representation
     */
    public CashDrawerDto toDto(CashDrawer entity) {
        if (entity == null) return null;
        CashDrawerDto dto = new CashDrawerDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CashDrawerDto
     * @return CashDrawer entity
     */
    public CashDrawer toEntity(CashDrawerDto dto) {
        if (dto == null) return null;
        CashDrawer entity = new CashDrawer();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of CashDrawer
     * @return list of CashDrawerDto
     */
    public List<CashDrawerDto> toDtoList(List<CashDrawer> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
