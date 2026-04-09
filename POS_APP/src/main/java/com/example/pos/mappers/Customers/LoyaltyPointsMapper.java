package com.example.pos.mappers.Customers;

import com.example.pos.entities.Customers.LoyaltyPoints;
import com.example.pos.dtos.Customers.LoyaltyPointsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for LoyaltyPoints entity.
 * <p>
 * Responsible for converting between LoyaltyPoints entity and LoyaltyPointsDto.
 */
@Component
public class LoyaltyPointsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the LoyaltyPoints entity
     * @return LoyaltyPointsDto representation
     */
    public LoyaltyPointsDto toDto(LoyaltyPoints entity) {
        if (entity == null) return null;
        LoyaltyPointsDto dto = new LoyaltyPointsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the LoyaltyPointsDto
     * @return LoyaltyPoints entity
     */
    public LoyaltyPoints toEntity(LoyaltyPointsDto dto) {
        if (dto == null) return null;
        LoyaltyPoints entity = new LoyaltyPoints();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of LoyaltyPoints
     * @return list of LoyaltyPointsDto
     */
    public List<LoyaltyPointsDto> toDtoList(List<LoyaltyPoints> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
