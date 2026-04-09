package com.example.pos.mappers.Customers;

import com.example.pos.entities.Customers.Memberships;
import com.example.pos.dtos.Customers.MembershipsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Memberships entity.
 * <p>
 * Responsible for converting between Memberships entity and MembershipsDto.
 */
@Component
public class MembershipsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Memberships entity
     * @return MembershipsDto representation
     */
    public MembershipsDto toDto(Memberships entity) {
        if (entity == null) return null;
        MembershipsDto dto = new MembershipsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the MembershipsDto
     * @return Memberships entity
     */
    public Memberships toEntity(MembershipsDto dto) {
        if (dto == null) return null;
        Memberships entity = new Memberships();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Memberships
     * @return list of MembershipsDto
     */
    public List<MembershipsDto> toDtoList(List<Memberships> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
