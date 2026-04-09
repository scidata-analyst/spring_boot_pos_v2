package com.example.pos.mappers.Reports;

import com.example.pos.entities.Reports.StockReport;
import com.example.pos.dtos.Reports.StockReportDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for StockReport entity.
 * <p>
 * Responsible for converting between StockReport entity and StockReportDto.
 */
@Component
public class StockReportMapper {

    /**
     * Convert entity to DTO.
     * @param entity the StockReport entity
     * @return StockReportDto representation
     */
    public StockReportDto toDto(StockReport entity) {
        if (entity == null) return null;
        StockReportDto dto = new StockReportDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the StockReportDto
     * @return StockReport entity
     */
    public StockReport toEntity(StockReportDto dto) {
        if (dto == null) return null;
        StockReport entity = new StockReport();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of StockReport
     * @return list of StockReportDto
     */
    public List<StockReportDto> toDtoList(List<StockReport> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
