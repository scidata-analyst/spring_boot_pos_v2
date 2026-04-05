package com.scidata_analyst.pos.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierSummaryResponse {

    private Long id;
    private String name;
    private String contactPerson;
    private String phone;
    private String email;
}
