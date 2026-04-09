package com.example.pos.mappers.Sales;

import com.example.pos.entities.Sales.HeldOrders;
import com.example.pos.dtos.Sales.HeldOrdersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for HeldOrders entity.
 * <p>
 * Responsible for converting between HeldOrders entity and HeldOrdersDto.
 */
@Component
public class HeldOrdersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the HeldOrders entity
     * @return HeldOrdersDto representation
     */
    public HeldOrdersDto toDto(HeldOrders entity) {
        if (entity == null) return null;
        HeldOrdersDto dto = new HeldOrdersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the HeldOrdersDto
     * @return HeldOrders entity
     */
    public HeldOrders toEntity(HeldOrdersDto dto) {
        if (dto == null) return null;
        HeldOrders entity = new HeldOrders();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of HeldOrders
     * @return list of HeldOrdersDto
     */
    public List<HeldOrdersDto> toDtoList(List<HeldOrders> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
