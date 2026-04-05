package com.scidata_analyst.pos.response.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private Long productCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
