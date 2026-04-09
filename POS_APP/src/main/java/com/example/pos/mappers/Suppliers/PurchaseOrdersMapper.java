package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.PurchaseOrders;
import com.example.pos.dtos.Suppliers.PurchaseOrdersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for PurchaseOrders entity.
 * <p>
 * Responsible for converting between PurchaseOrders entity and PurchaseOrdersDto.
 */
@Component
public class PurchaseOrdersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the PurchaseOrders entity
     * @return PurchaseOrdersDto representation
     */
    public PurchaseOrdersDto toDto(PurchaseOrders entity) {
        if (entity == null) return null;
        PurchaseOrdersDto dto = new PurchaseOrdersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the PurchaseOrdersDto
     * @return PurchaseOrders entity
     */
    public PurchaseOrders toEntity(PurchaseOrdersDto dto) {
        if (dto == null) return null;
        PurchaseOrders entity = new PurchaseOrders();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of PurchaseOrders
     * @return list of PurchaseOrdersDto
     */
    public List<PurchaseOrdersDto> toDtoList(List<PurchaseOrders> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
