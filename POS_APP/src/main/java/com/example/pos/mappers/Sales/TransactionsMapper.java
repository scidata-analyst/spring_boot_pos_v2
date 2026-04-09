package com.example.pos.mappers.Sales;

import com.example.pos.entities.Sales.Transactions;
import com.example.pos.dtos.Sales.TransactionsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for Transactions entity.
 * <p>
 * Responsible for converting between Transactions entity and TransactionsDto.
 */
@Component
public class TransactionsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the Transactions entity
     * @return TransactionsDto representation
     */
    public TransactionsDto toDto(Transactions entity) {
        if (entity == null) return null;
        TransactionsDto dto = new TransactionsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the TransactionsDto
     * @return Transactions entity
     */
    public Transactions toEntity(TransactionsDto dto) {
        if (dto == null) return null;
        Transactions entity = new Transactions();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of Transactions
     * @return list of TransactionsDto
     */
    public List<TransactionsDto> toDtoList(List<Transactions> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
