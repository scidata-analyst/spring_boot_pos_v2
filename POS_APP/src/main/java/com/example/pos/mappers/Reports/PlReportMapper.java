package com.example.pos.mappers.Reports;

import com.example.pos.entities.Reports.PlReport;
import com.example.pos.dtos.Reports.PlReportDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for PlReport entity.
 * <p>
 * Responsible for converting between PlReport entity and PlReportDto.
 */
@Component
public class PlReportMapper {

    /**
     * Convert entity to DTO.
     * @param entity the PlReport entity
     * @return PlReportDto representation
     */
    public PlReportDto toDto(PlReport entity) {
        if (entity == null) return null;
        PlReportDto dto = new PlReportDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the PlReportDto
     * @return PlReport entity
     */
    public PlReport toEntity(PlReportDto dto) {
        if (dto == null) return null;
        PlReport entity = new PlReport();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of PlReport
     * @return list of PlReportDto
     */
    public List<PlReportDto> toDtoList(List<PlReport> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
