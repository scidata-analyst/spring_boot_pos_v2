package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.StockMovement;
import com.example.pos.dtos.Products.StockMovementDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for StockMovement entity.
 * <p>
 * Responsible for converting between StockMovement entity and StockMovementDto.
 */
@Component
public class StockMovementMapper {

    /**
     * Convert entity to DTO.
     * @param entity the StockMovement entity
     * @return StockMovementDto representation
     */
    public StockMovementDto toDto(StockMovement entity) {
        if (entity == null) return null;
        StockMovementDto dto = new StockMovementDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the StockMovementDto
     * @return StockMovement entity
     */
    public StockMovement toEntity(StockMovementDto dto) {
        if (dto == null) return null;
        StockMovement entity = new StockMovement();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of StockMovement
     * @return list of StockMovementDto
     */
    public List<StockMovementDto> toDtoList(List<StockMovement> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
