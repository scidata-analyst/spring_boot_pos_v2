package com.example.pos.mappers.Sales;

import com.example.pos.entities.Sales.Returns;
import com.example.pos.dtos.Sales.ReturnsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Returns entity.
 * <p>
 * Responsible for converting between Returns entity and ReturnsDto.
 */
@Component
public class ReturnsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Returns entity
     * @return ReturnsDto representation
     */
    public ReturnsDto toDto(Returns entity) {
        if (entity == null) return null;
        ReturnsDto dto = new ReturnsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the ReturnsDto
     * @return Returns entity
     */
    public Returns toEntity(ReturnsDto dto) {
        if (dto == null) return null;
        Returns entity = new Returns();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Returns
     * @return list of ReturnsDto
     */
    public List<ReturnsDto> toDtoList(List<Returns> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
