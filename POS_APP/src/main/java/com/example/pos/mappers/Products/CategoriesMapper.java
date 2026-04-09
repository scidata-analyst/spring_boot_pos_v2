package com.example.pos.mappers.Products;

import com.example.pos.entities.Products.Categories;
import com.example.pos.dtos.Products.CategoriesDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Categories entity.
 * <p>
 * Responsible for converting between Categories entity and CategoriesDto.
 */
@Component
public class CategoriesMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Categories entity
     * @return CategoriesDto representation
     */
    public CategoriesDto toDto(Categories entity) {
        if (entity == null) return null;
        CategoriesDto dto = new CategoriesDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CategoriesDto
     * @return Categories entity
     */
    public Categories toEntity(CategoriesDto dto) {
        if (dto == null) return null;
        Categories entity = new Categories();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Categories
     * @return list of CategoriesDto
     */
    public List<CategoriesDto> toDtoList(List<Categories> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
