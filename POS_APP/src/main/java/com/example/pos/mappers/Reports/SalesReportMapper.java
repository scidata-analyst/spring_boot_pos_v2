package com.example.pos.mappers.Reports;

import com.example.pos.entities.Reports.SalesReport;
import com.example.pos.dtos.Reports.SalesReportDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for SalesReport entity.
 * <p>
 * Responsible for converting between SalesReport entity and SalesReportDto.
 */
@Component
public class SalesReportMapper {

    /**
     * Convert entity to DTO.
     * @param entity the SalesReport entity
     * @return SalesReportDto representation
     */
    public SalesReportDto toDto(SalesReport entity) {
        if (entity == null) return null;
        SalesReportDto dto = new SalesReportDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the SalesReportDto
     * @return SalesReport entity
     */
    public SalesReport toEntity(SalesReportDto dto) {
        if (dto == null) return null;
        SalesReport entity = new SalesReport();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of SalesReport
     * @return list of SalesReportDto
     */
    public List<SalesReportDto> toDtoList(List<SalesReport> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
