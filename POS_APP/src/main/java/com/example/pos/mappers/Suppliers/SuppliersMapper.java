package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.Suppliers;
import com.example.pos.dtos.Suppliers.SuppliersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Suppliers entity.
 * <p>
 * Responsible for converting between Suppliers entity and SuppliersDto.
 */
@Component
public class SuppliersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Suppliers entity
     * @return SuppliersDto representation
     */
    public SuppliersDto toDto(Suppliers entity) {
        if (entity == null) return null;
        SuppliersDto dto = new SuppliersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the SuppliersDto
     * @return Suppliers entity
     */
    public Suppliers toEntity(SuppliersDto dto) {
        if (dto == null) return null;
        Suppliers entity = new Suppliers();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Suppliers
     * @return list of SuppliersDto
     */
    public List<SuppliersDto> toDtoList(List<Suppliers> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
