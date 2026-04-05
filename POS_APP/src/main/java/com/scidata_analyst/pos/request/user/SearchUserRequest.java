package com.scidata_analyst.pos.request.user;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserRequest {

    private String keyword;

    private String email;

    private Boolean isActive;

    @Min(value = 0, message = "Page must be non-negative")
    @Builder.Default
    private Integer page = 0;

    @Min(value = 1, message = "Size must be at least 1")
    @Builder.Default
    private Integer size = 10;

    @Builder.Default
    private String sortBy = "username";

    @Builder.Default
    private String sortDir = "asc";
}
