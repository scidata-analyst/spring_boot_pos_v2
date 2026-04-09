package com.example.pos.mappers.Core;

import com.example.pos.entities.Core.PosTerminal;
import com.example.pos.dtos.Core.PosTerminalDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for PosTerminal entity.
 * <p>
 * Responsible for converting between PosTerminal entity and PosTerminalDto.
 */
@Component
public class PosTerminalMapper {

    /**
     * Convert entity to DTO.
     * @param entity the PosTerminal entity
     * @return PosTerminalDto representation
     */
    public PosTerminalDto toDto(PosTerminal entity) {
        if (entity == null) return null;
        PosTerminalDto dto = new PosTerminalDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the PosTerminalDto
     * @return PosTerminal entity
     */
    public PosTerminal toEntity(PosTerminalDto dto) {
        if (dto == null) return null;
        PosTerminal entity = new PosTerminal();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of PosTerminal
     * @return list of PosTerminalDto
     */
    public List<PosTerminalDto> toDtoList(List<PosTerminal> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
