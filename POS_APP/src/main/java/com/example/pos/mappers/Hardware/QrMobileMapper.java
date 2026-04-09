package com.example.pos.mappers.Hardware;

import com.example.pos.entities.Hardware.QrMobile;
import com.example.pos.dtos.Hardware.QrMobileDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for QrMobile entity.
 * <p>
 * Responsible for converting between QrMobile entity and QrMobileDto.
 */
@Component
public class QrMobileMapper {

    /**
     * Convert entity to DTO.
     * @param entity the QrMobile entity
     * @return QrMobileDto representation
     */
    public QrMobileDto toDto(QrMobile entity) {
        if (entity == null) return null;
        QrMobileDto dto = new QrMobileDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the QrMobileDto
     * @return QrMobile entity
     */
    public QrMobile toEntity(QrMobileDto dto) {
        if (dto == null) return null;
        QrMobile entity = new QrMobile();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of QrMobile
     * @return list of QrMobileDto
     */
    public List<QrMobileDto> toDtoList(List<QrMobile> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
