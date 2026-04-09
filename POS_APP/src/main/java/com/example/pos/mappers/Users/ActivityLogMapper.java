package com.example.pos.mappers.Users;

import com.example.pos.entities.Users.ActivityLog;
import com.example.pos.dtos.Users.ActivityLogDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for ActivityLog entity.
 * <p>
 * Responsible for converting between ActivityLog entity and ActivityLogDto.
 */
@Component
public class ActivityLogMapper {

    /**
     * Convert entity to DTO.
     * @param entity the ActivityLog entity
     * @return ActivityLogDto representation
     */
    public ActivityLogDto toDto(ActivityLog entity) {
        if (entity == null) return null;
        ActivityLogDto dto = new ActivityLogDto();
        dto.setId(entity.getId());
        // TODO: map other fields
        return dto;
    }

    /**
     * Convert DTO to entity.
     * @param dto the ActivityLogDto
     * @return ActivityLog entity
     */
    public ActivityLog toEntity(ActivityLogDto dto) {
        if (dto == null) return null;
        ActivityLog entity = new ActivityLog();
        entity.setId(dto.getId());
        // TODO: map other fields
        return entity;
    }

    /**
     * Convert list of entities to list of DTOs.
     * @param entities list of ActivityLog
     * @return list of ActivityLogDto
     */
    public List<ActivityLogDto> toDtoList(List<ActivityLog> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
