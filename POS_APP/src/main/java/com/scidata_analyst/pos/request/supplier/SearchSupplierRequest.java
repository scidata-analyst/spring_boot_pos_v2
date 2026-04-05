package com.scidata_analyst.pos.request.supplier;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchSupplierRequest {

    private String keyword;

    private String email;

    private String phone;

    private Boolean isActive;

    @Min(value = 0, message = "Page must be non-negative")
    @Builder.Default
    private Integer page = 0;

    @Min(value = 1, message = "Size must be at least 1")
    @Builder.Default
    private Integer size = 10;

    @Builder.Default
    private String sortBy = "name";

    @Builder.Default
    private String sortDir = "asc";
}
