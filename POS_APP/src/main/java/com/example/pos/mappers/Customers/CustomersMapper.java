package com.example.pos.mappers.Customers;

import com.example.pos.entities.Customers.Customers;
import com.example.pos.dtos.Customers.CustomersDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Customers entity.
 * <p>
 * Responsible for converting between Customers entity and CustomersDto.
 */
@Component
public class CustomersMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Customers entity
     * @return CustomersDto representation
     */
    public CustomersDto toDto(Customers entity) {
        if (entity == null) return null;
        CustomersDto dto = new CustomersDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CustomersDto
     * @return Customers entity
     */
    public Customers toEntity(CustomersDto dto) {
        if (dto == null) return null;
        Customers entity = new Customers();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Customers
     * @return list of CustomersDto
     */
    public List<CustomersDto> toDtoList(List<Customers> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
