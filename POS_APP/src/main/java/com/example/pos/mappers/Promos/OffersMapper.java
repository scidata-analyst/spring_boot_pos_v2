package com.example.pos.mappers.Promos;

import com.example.pos.entities.Promos.Offers;
import com.example.pos.dtos.Promos.OffersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Offers entity.
 * <p>
 * Responsible for converting between Offers entity and OffersDto.
 */
@Component
public class OffersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Offers entity
     * @return OffersDto representation
     */
    public OffersDto toDto(Offers entity) {
        if (entity == null) return null;
        OffersDto dto = new OffersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the OffersDto
     * @return Offers entity
     */
    public Offers toEntity(OffersDto dto) {
        if (dto == null) return null;
        Offers entity = new Offers();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Offers
     * @return list of OffersDto
     */
    public List<OffersDto> toDtoList(List<Offers> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
