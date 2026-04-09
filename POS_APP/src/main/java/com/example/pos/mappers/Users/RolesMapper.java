package com.example.pos.mappers.Users;

import com.example.pos.entities.Users.Roles;
import com.example.pos.dtos.Users.RolesDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Roles entity.
 * <p>
 * Responsible for converting between Roles entity and RolesDto.
 */
@Component
public class RolesMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Roles entity
     * @return RolesDto representation
     */
    public RolesDto toDto(Roles entity) {
        if (entity == null) return null;
        RolesDto dto = new RolesDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the RolesDto
     * @return Roles entity
     */
    public Roles toEntity(RolesDto dto) {
        if (dto == null) return null;
        Roles entity = new Roles();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Roles
     * @return list of RolesDto
     */
    public List<RolesDto> toDtoList(List<Roles> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
