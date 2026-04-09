package com.example.pos.mappers.Reports;

import com.example.pos.entities.Reports.CustomReport;
import com.example.pos.dtos.Reports.CustomReportDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for CustomReport entity.
 * <p>
 * Responsible for converting between CustomReport entity and CustomReportDto.
 */
@Component
public class CustomReportMapper {

    /**
     * Convert entity to DTO.
     * @param entity the CustomReport entity
     * @return CustomReportDto representation
     */
    public CustomReportDto toDto(CustomReport entity) {
        if (entity == null) return null;
        CustomReportDto dto = new CustomReportDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the CustomReportDto
     * @return CustomReport entity
     */
    public CustomReport toEntity(CustomReportDto dto) {
        if (dto == null) return null;
        CustomReport entity = new CustomReport();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of CustomReport
     * @return list of CustomReportDto
     */
    public List<CustomReportDto> toDtoList(List<CustomReport> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
