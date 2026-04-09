package com.example.pos.mappers.Loyalty;

import com.example.pos.entities.Loyalty.TierManagement;
import com.example.pos.dtos.Loyalty.TierManagementDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for TierManagement entity.
 * <p>
 * Responsible for converting between TierManagement entity and TierManagementDto.
 */
@Component
public class TierManagementMapper {

    /**
     * Convert entity to DTO.
     * @param entity the TierManagement entity
     * @return TierManagementDto representation
     */
    public TierManagementDto toDto(TierManagement entity) {
        if (entity == null) return null;
        TierManagementDto dto = new TierManagementDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the TierManagementDto
     * @return TierManagement entity
     */
    public TierManagement toEntity(TierManagementDto dto) {
        if (dto == null) return null;
        TierManagement entity = new TierManagement();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of TierManagement
     * @return list of TierManagementDto
     */
    public List<TierManagementDto> toDtoList(List<TierManagement> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
