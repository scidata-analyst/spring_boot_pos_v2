package com.example.pos.mappers.Accounting;

import com.example.pos.entities.Accounting.TaxReports;
import com.example.pos.dtos.Accounting.TaxReportsDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for TaxReports entity.
 * <p>
 * Responsible for converting between TaxReports entity and TaxReportsDto.
 */
@Component
public class TaxReportsMapper {

    /**
     * Convert entity to DTO.
     * @param entity the TaxReports entity
     * @return TaxReportsDto representation
     */
    public TaxReportsDto toDto(TaxReports entity) {
        if (entity == null) return null;
        TaxReportsDto dto = new TaxReportsDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the TaxReportsDto
     * @return TaxReports entity
     */
    public TaxReports toEntity(TaxReportsDto dto) {
        if (dto == null) return null;
        TaxReports entity = new TaxReports();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of TaxReports
     * @return list of TaxReportsDto
     */
    public List<TaxReportsDto> toDtoList(List<TaxReports> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
