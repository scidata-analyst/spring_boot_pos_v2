package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.Barcodes;
import com.example.pos.dtos.Products.BarcodesDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Barcodes entity.
 * <p>
 * Responsible for converting between Barcodes entity and BarcodesDto.
 */
@Component
public class BarcodesMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Barcodes entity
     * @return BarcodesDto representation
     */
    public BarcodesDto toDto(Barcodes entity) {
        if (entity == null) return null;
        BarcodesDto dto = new BarcodesDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the BarcodesDto
     * @return Barcodes entity
     */
    public Barcodes toEntity(BarcodesDto dto) {
        if (dto == null) return null;
        Barcodes entity = new Barcodes();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Barcodes
     * @return list of BarcodesDto
     */
    public List<BarcodesDto> toDtoList(List<Barcodes> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
