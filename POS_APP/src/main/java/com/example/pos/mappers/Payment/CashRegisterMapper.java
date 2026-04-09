package com.example.pos.mappers.Payment;

import com.example.pos.entities.Payment.CashRegister;
import com.example.pos.dtos.Payment.CashRegisterDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for CashRegister entity.
 * <p>
 * Responsible for converting between CashRegister entity and CashRegisterDto.
 */
@Component
public class CashRegisterMapper {

    /**
     * Convert entity to DTO.
     * @param entity the CashRegister entity
     * @return CashRegisterDto representation
     */
    public CashRegisterDto toDto(CashRegister entity) {
        if (entity == null) return null;
        CashRegisterDto dto = new CashRegisterDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CashRegisterDto
     * @return CashRegister entity
     */
    public CashRegister toEntity(CashRegisterDto dto) {
        if (dto == null) return null;
        CashRegister entity = new CashRegister();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of CashRegister
     * @return list of CashRegisterDto
     */
    public List<CashRegisterDto> toDtoList(List<CashRegister> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
