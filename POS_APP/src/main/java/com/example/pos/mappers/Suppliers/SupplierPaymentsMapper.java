package com.example.pos.mappers.Suppliers;

import com.example.pos.entities.Suppliers.SupplierPayments;
import com.example.pos.dtos.Suppliers.SupplierPaymentsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for SupplierPayments entity.
 * <p>
 * Responsible for converting between SupplierPayments entity and SupplierPaymentsDto.
 */
@Component
public class SupplierPaymentsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the SupplierPayments entity
     * @return SupplierPaymentsDto representation
     */
    public SupplierPaymentsDto toDto(SupplierPayments entity) {
        if (entity == null) return null;
        SupplierPaymentsDto dto = new SupplierPaymentsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the SupplierPaymentsDto
     * @return SupplierPayments entity
     */
    public SupplierPayments toEntity(SupplierPaymentsDto dto) {
        if (dto == null) return null;
        SupplierPayments entity = new SupplierPayments();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of SupplierPayments
     * @return list of SupplierPaymentsDto
     */
    public List<SupplierPaymentsDto> toDtoList(List<SupplierPayments> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
