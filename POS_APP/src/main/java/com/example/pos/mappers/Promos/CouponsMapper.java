package com.example.pos.mappers.Promos;

import com.example.pos.entities.Promos.Coupons;
import com.example.pos.dtos.Promos.CouponsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Coupons entity.
 * <p>
 * Responsible for converting between Coupons entity and CouponsDto.
 */
@Component
public class CouponsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Coupons entity
     * @return CouponsDto representation
     */
    public CouponsDto toDto(Coupons entity) {
        if (entity == null) return null;
        CouponsDto dto = new CouponsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CouponsDto
     * @return Coupons entity
     */
    public Coupons toEntity(CouponsDto dto) {
        if (dto == null) return null;
        Coupons entity = new Coupons();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Coupons
     * @return list of CouponsDto
     */
    public List<CouponsDto> toDtoList(List<Coupons> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
