package com.example.pos.mappers.Sales;

import com.example.pos.entities.Sales.Invoices;
import com.example.pos.dtos.Sales.InvoicesDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Invoices entity.
 * <p>
 * Responsible for converting between Invoices entity and InvoicesDto.
 */
@Component
public class InvoicesMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Invoices entity
     * @return InvoicesDto representation
     */
    public InvoicesDto toDto(Invoices entity) {
        if (entity == null) return null;
        InvoicesDto dto = new InvoicesDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the InvoicesDto
     * @return Invoices entity
     */
    public Invoices toEntity(InvoicesDto dto) {
        if (dto == null) return null;
        Invoices entity = new Invoices();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Invoices
     * @return list of InvoicesDto
     */
    public List<InvoicesDto> toDtoList(List<Invoices> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
