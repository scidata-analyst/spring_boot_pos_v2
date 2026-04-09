package com.example.pos.mappers.Payment;

import com.example.pos.entities.Payment.Reconciliation;
import com.example.pos.dtos.Payment.ReconciliationDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Reconciliation entity.
 * <p>
 * Responsible for converting between Reconciliation entity and ReconciliationDto.
 */
@Component
public class ReconciliationMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Reconciliation entity
     * @return ReconciliationDto representation
     */
    public ReconciliationDto toDto(Reconciliation entity) {
        if (entity == null) return null;
        ReconciliationDto dto = new ReconciliationDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the ReconciliationDto
     * @return Reconciliation entity
     */
    public Reconciliation toEntity(ReconciliationDto dto) {
        if (dto == null) return null;
        Reconciliation entity = new Reconciliation();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Reconciliation
     * @return list of ReconciliationDto
     */
    public List<ReconciliationDto> toDtoList(List<Reconciliation> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
