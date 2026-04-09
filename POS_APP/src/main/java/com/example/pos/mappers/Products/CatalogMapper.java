package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.Catalog;
import com.example.pos.dtos.Products.CatalogDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Catalog entity.
 * <p>
 * Responsible for converting between Catalog entity and CatalogDto.
 */
@Component
public class CatalogMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Catalog entity
     * @return CatalogDto representation
     */
    public CatalogDto toDto(Catalog entity) {
        if (entity == null) return null;
        CatalogDto dto = new CatalogDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CatalogDto
     * @return Catalog entity
     */
    public Catalog toEntity(CatalogDto dto) {
        if (dto == null) return null;
        Catalog entity = new Catalog();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Catalog
     * @return list of CatalogDto
     */
    public List<CatalogDto> toDtoList(List<Catalog> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
