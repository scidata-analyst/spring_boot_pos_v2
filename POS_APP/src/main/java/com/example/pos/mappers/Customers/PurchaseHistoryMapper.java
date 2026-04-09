package com.example.pos.mappers.Customers;

import com.example.pos.entities.Customers.PurchaseHistory;
import com.example.pos.dtos.Customers.PurchaseHistoryDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for PurchaseHistory entity.
 * <p>
 * Responsible for converting between PurchaseHistory entity and PurchaseHistoryDto.
 */
@Component
public class PurchaseHistoryMapper {

    /**
     * Convert entity to DTO.
     * @param entity the PurchaseHistory entity
     * @return PurchaseHistoryDto representation
     */
    public PurchaseHistoryDto toDto(PurchaseHistory entity) {
        if (entity == null) return null;
        PurchaseHistoryDto dto = new PurchaseHistoryDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the PurchaseHistoryDto
     * @return PurchaseHistory entity
     */
    public PurchaseHistory toEntity(PurchaseHistoryDto dto) {
        if (dto == null) return null;
        PurchaseHistory entity = new PurchaseHistory();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of PurchaseHistory
     * @return list of PurchaseHistoryDto
     */
    public List<PurchaseHistoryDto> toDtoList(List<PurchaseHistory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
