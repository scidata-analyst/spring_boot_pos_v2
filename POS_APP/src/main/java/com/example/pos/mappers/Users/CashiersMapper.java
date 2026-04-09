package com.example.pos.mappers.Users;

import com.example.pos.entities.Users.Cashiers;
import com.example.pos.dtos.Users.CashiersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Cashiers entity.
 * <p>
 * Responsible for converting between Cashiers entity and CashiersDto.
 */
@Component
public class CashiersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Cashiers entity
     * @return CashiersDto representation
     */
    public CashiersDto toDto(Cashiers entity) {
        if (entity == null) return null;
        CashiersDto dto = new CashiersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CashiersDto
     * @return Cashiers entity
     */
    public Cashiers toEntity(CashiersDto dto) {
        if (dto == null) return null;
        Cashiers entity = new Cashiers();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Cashiers
     * @return list of CashiersDto
     */
    public List<CashiersDto> toDtoList(List<Cashiers> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
