package com.scidata_analyst.pos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSummaryResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private Double loyaltyPoints;
}
